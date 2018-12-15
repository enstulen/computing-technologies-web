package requestHandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import entities.Booking;
import entities.Home;
import entities.Message;
import entities.User;

public class SendMessagesRequestHandler implements RequestHandler {

	private Datastore dataStore;

	public SendMessagesRequestHandler() {
		dataStore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		
		User currentUser = (User) request.getSession().getAttribute("user");

		String type = request.getParameter("type");
        if (type.equals("booking") || type.equals("messageWithoutReciever")) {
        	String idString = request.getParameter("homeid");
			Home home = dataStore.getHome(Integer.parseInt(idString));
			request.setAttribute("home", home);
        	sView = "detailHome.jsp";
        } else if (type.equals("message")) {
			sView = "messages.jsp";
        }        
        
		try {

			Message message = new Message();
			User sender = (User) request.getSession().getAttribute("user");
			message.setSender(sender);
			message.setTime_stamp(new Date());
			
	        if (type.equals("booking")) {
	        	
	        	// == BOOK == 
				String card_number = request.getParameter("card_number");
				int hostid = Integer.parseInt(request.getParameter("hostid"));
				int homeid = Integer.parseInt(request.getParameter("homeid"));
				
				Booking booking = new Booking();
				booking.setCard_number(card_number);
				booking.setGuest(dataStore.getCurrentUser());
				booking.setHost(dataStore.getUser(hostid));
				booking.setConfirmed(0);
				
				booking.setHome(dataStore.getHome(homeid));
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
				
				dataStore.createNewBooking(booking);
	        	
	        	// ======= // 
				
	         	String idString = request.getParameter("homeid");
				Home home = dataStore.getHome(Integer.parseInt(idString));
				
	        	String hostidString = request.getParameter("hostid");
	        	
	        	User host = dataStore.getUser(Integer.parseInt(hostidString));
				message.setReciever(host);
				message.setText("Booking: " + booking.getBookingid() +  " - Hi, I want to books this house: " + home.getName() + " from " + date_start + " to " + date_end);
	        } else if (type.equals("messageWithoutReciever")) {
	           	String hostidString = request.getParameter("hostid");
	        	User host = dataStore.getUser(Integer.parseInt(hostidString));
				message.setReciever(host);
				message.setText(request.getParameter("message"));
	        }
        	else if (type.equals("message")) {
        		User reciever = (User)dataStore.findUser(request.getParameter("receiver"));
				message.setReciever(reciever);
				message.setText(request.getParameter("message"));
	        }
			dataStore.createNewMessage(message);
			
		}catch (Exception e) {
			System.out.println("JHC *************************************** Error in doPost: " + e.toString());

		}
		List<entities.Message> messages = (List<entities.Message>) dataStore.getMessagesForUser(currentUser);
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);

		return sView;
	}

}
