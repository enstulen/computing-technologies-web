package requestHandlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookingBean;
import beans.HomeBean;
import beans.UserBean;
import datastore.Datastore;

public class AdminRequestHandler implements RequestHandler {
	
	private Datastore datastore;
	
	public AdminRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/admin.html")) {
			ArrayList<HomeBean> homes = (ArrayList<HomeBean>) datastore.getHomes();
			ArrayList<BookingBean> bookings = (ArrayList<BookingBean>) datastore.getBookings();
			ArrayList<UserBean> users = (ArrayList<UserBean>) datastore.getUsers();

			request.setAttribute("homes", homes);
			request.setAttribute("bookings", bookings);
			request.setAttribute("users", users);

			sView = "admin.jsp";
		}
		

		return sView;
	}

}
