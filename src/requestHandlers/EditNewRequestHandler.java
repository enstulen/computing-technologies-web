package requestHandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Home;
import datastore.Datastore;

public class EditNewRequestHandler implements RequestHandler {
	
	private Datastore datastore;
	
	public EditNewRequestHandler() {
		this.datastore = Datastore.getInstance();
	} 

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		String id = null;

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
			sView = "/edit-new-pages/edit-new-home.jsp";
		}
		return sView;
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