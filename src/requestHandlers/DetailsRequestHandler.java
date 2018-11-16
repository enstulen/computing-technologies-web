package requestHandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.Booking;
import entities.Home;

public class DetailsRequestHandler implements RequestHandler {

	private Datastore datastore;

	public DetailsRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/details") || path.equals("/details.html")) {
			
			if ("POST".equalsIgnoreCase(request.getMethod())) {
				String card_number = request.getParameter("card_number");
				int hostid = Integer.parseInt(request.getParameter("hostid"));
				int homeid = Integer.parseInt(request.getParameter("homeid"));
				
				Booking booking = new Booking();
				booking.setCard_number(card_number);
				booking.setGuest(datastore.getCurrentUser());
				booking.setHost(datastore.getUser(hostid));
				booking.setConfirmed(false);
				booking.setHome(datastore.getHome(homeid));
				booking.setDate_booking(new Date());
				
				String date_start = request.getParameter("date-start");
				String date_end = request.getParameter("date-end");

				try {
					Date start = new SimpleDateFormat("MM/dd/yyyy").parse(date_start);
					Date end = new SimpleDateFormat("MM/dd/yyyy").parse(date_end);
					booking.setDate_start(start);
					booking.setDate_end(end);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				datastore.createNewBooking(booking);
				
				
			} else {
				Home home;
				String idString = request.getParameter("id");
				int id = 0;
				try {
					id = Integer.parseInt(idString);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				home = datastore.getHome(id);

				if (home==null) {
					return "notFound.jsp";
				}

        
				request.setAttribute("home", home);
				sView = "detailHome.jsp";
			}
		}

		return sView;
	}

}
