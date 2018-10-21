package requestHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Home;
import datastore.Datastore;

public class EditNewRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.contains("/edit-new-home.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				String id = parameters[parameters.length - 1]; //Since there is only 1 query param atm
				Home home = Datastore.getInstance().getHome(Integer.parseInt(id));
				request.setAttribute("home", home);
			}			
			sView = "/edit-new-pages/edit-new-home.jsp";
		} else if (path.equals("/edit-new-booking.html")) {
			sView = "/edit-new-pages/edit-new-booking.jsp";
		}
		
		System.out.println(sView);

		return sView;
	}

}
