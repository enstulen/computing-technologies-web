package requestHandlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Booking;
import entities.Home;
import entities.Message;
import entities.User;
import datastore.Datastore;

public class EditNewRequestHandler implements RequestHandler {

	private Datastore datastore;
	private SimpleDateFormat s;

	public EditNewRequestHandler() {
		this.datastore = Datastore.getInstance();
		this.s = new SimpleDateFormat("YYY-MM-dd");
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		String id = null;
		// home page
		if (request.getServletPath().equalsIgnoreCase("/edit-new-home.html")) {

			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateHome(request, Integer.parseInt(id));
				} else {
					createUpdateHome(request, null);
				}
			} else {
				if (id != null) {
					Home home = datastore.getHome(Integer.parseInt(id));
					request.setAttribute("home", home);
				}
				request.setAttribute("admin", true);
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-home.jsp";
			}
			// booking page
		} else if (request.getServletPath().equalsIgnoreCase("/edit-new-booking.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateBooking(request, Integer.parseInt(id));
				} else {
					createUpdateBooking(request, null);
				}
			} else {
				if (id != null) {
					Booking booking = datastore.getBooking(Integer.parseInt(id));
					request.setAttribute("booking", booking);
				}
				request.setAttribute("admin", true);
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-booking.jsp";
			}
			// user page
		} else if (request.getServletPath().equalsIgnoreCase("/edit-new-user.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateUser(request, Integer.parseInt(id));
				} else {
					createUpdateUser(request, null);
				}
			} else {
				if (id != null) {
					User user = datastore.getUser(Integer.parseInt(id));
					request.setAttribute("user", user);
				}
				request.setAttribute("admin", true);
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-user.jsp";
			}
			// message page
		} else if (request.getServletPath().equalsIgnoreCase("/edit-new-message.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateMessage(request, Integer.parseInt(id));
				} else {
					createUpdateMessage(request, null);
				}
			} else {
				if (id != null) {
					Message message = datastore.getMessage(Integer.parseInt(id));
					request.setAttribute("message", message);
				}
				request.setAttribute("admin", true);
				
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-message.jsp";
			}
		}
		return sView;
	}

	private void createUpdateMessage(HttpServletRequest request, Integer messageId) {
		// TODO Auto-generated method stub

	}

	private void createUpdateUser(HttpServletRequest request, Integer userId) {
		// TODO Auto-generated method stub

	}

	private void createUpdateBooking(HttpServletRequest request, Integer bookingId) {
		Booking booking;
		if (bookingId == null) {
			booking = new Booking();
		} else {
			booking = datastore.getBooking(bookingId);
		}
		
		Date start,end,booked=null;
		String homeId = request.getParameter("homeId");
		String guestId = request.getParameter("guestId");
		String dateStart = request.getParameter("date_start");
		String dateEnd=request.getParameter("date_end");
		String dateBooked=request.getParameter("date_booked");
		String cardNumber=request.getParameter("card_number");
		
		if (dateStart!=null &&dateEnd != null) {
			try {				
				start=s.parse(dateStart);
				end=s.parse(dateEnd);
				booked=s.parse(dateBooked);
				
				if(!start.after(end)) {
					if (dateStart != null && start.before(booking.getDate_start())) {
						booking.setDate_start(start);
					}
					if(dateEnd !=null && end.after(booking.getDate_end()))
					{
						booking.setDate_end(end);
					}
					
					if (dateBooked != null && booked.before(booking.getDate_start())) {
						booking.setDate_booking(booked);
					}
				}
			}
			catch(ParseException e) {
			
			}
		}
		
		if(cardNumber!=null) {
			booking.setCard_number(cardNumber);
		}
		

		if (homeId != null) {
			booking.setHome(datastore.getHome(Integer.parseInt(homeId)));
		} 
		
		if (guestId != null) {
			booking.setGuest(datastore.getUser(Integer.parseInt(guestId)));
		} 

		
		

		
		if (bookingId == null) {
			datastore.createNewBooking(booking);
		} else {
			datastore.updateBooking(booking);
		}

	}

	private void createUpdateHome(HttpServletRequest request, Integer homeID) {
		Home home = null;
		if (homeID == null) {
			home = new Home();
		} else {
			home = datastore.getHome(homeID);
		}

		String name = request.getParameter("name");
		String full_description = request.getParameter("full_description");
		String short_description = request.getParameter("short_description");
		String typeString = request.getParameter("type");
		int type;

		if (typeString != null) {
			switch (typeString) {
			case "entire":
				type = 0;
				break;
			case "private":
				type = 1;
				break;
			case "shared":
				type = 2;
				break;
			default:
				type = 0;
				break;
			}
		} else {
			type = 0;
		}

		int number_of_guests = Integer.parseInt(request.getParameter("number_of_guests"));
		int price = Integer.parseInt(request.getParameter("price"));
		String date_start = request.getParameter("date-start");
		String date_end = request.getParameter("date-end");

		String user_id = request.getParameter("user_userid");

		if (user_id != null) {
			home.setUser(datastore.getUser(Integer.parseInt(user_id)));
		} else {
			home.setUser(datastore.getCurrentUser());
		}

		try {
			Date start = new SimpleDateFormat("MM/dd/yyyy").parse(date_start);
			Date end = new SimpleDateFormat("MM/dd/yyyy").parse(date_end);
			home.setDate_available_start(start);
			home.setDate_available_end(end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		home.setNumber_of_guests(number_of_guests);
		home.setName(name);
		home.setFull_description(full_description);
		home.setShort_description(short_description);
		home.setType(type);
		home.setPrice(price);
		if (homeID == null) {
			datastore.createNewHome(home);
		} else {
			datastore.updateHome(home);
		}
	}
}