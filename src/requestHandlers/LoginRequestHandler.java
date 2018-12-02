package requestHandlers;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datastore.Datastore;

import java.io.IOException;
import java.util.List;

import entities.User;

public class LoginRequestHandler {
	
	private Datastore dataStore;
	
	public LoginRequestHandler () {
		dataStore = Datastore.getInstance();
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		String message = "";
		String user = request.getParameter("loginEmail");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") != null) {
			message = "There is already a user logged in";
			request.setAttribute("message", message);
		} else {
			session.setAttribute("user", dataStore.getUsers().get(0).getName());
			message = "The user is " + ((User) session.getAttribute("user")).getEmail();
			sView = "bookings.html";
		}
		System.out.println(message);
		return sView;
	}
}
