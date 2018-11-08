package requestHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.User;

public class IndexRequestHandler implements RequestHandler {
	
	private Datastore datastore;
	
	public IndexRequestHandler() {
		this.datastore = datastore.getInstance();
	}


	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/index.html")) {
			sView = "index.jsp";
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			//Register
			if ((request.getParameter("name") != null) && (request.getParameter("surname") != null)) {
				 
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");

				User newUser = new User();
				newUser.setEmail(email);
				newUser.setPassword(password);
				newUser.setName(name);
				newUser.setSurname(surname);
				
				datastore.createNewUser(newUser);
				request.getSession().setAttribute("user", newUser);
				
			} 
			//Login
			else if ((email != null) && (password != null)){
				if (datastore.findUser(email, password) != null) {
					User user = datastore.findUser(email, password);				
					request.getSession().setAttribute("user", user);
				}
	
			}
			//Logout
			else if (request.getParameter("type") != null ) {
				if (request.getParameter("type").equals("logout")) {
					request.getSession().removeAttribute("user");
				}
			}
		}
		return sView;
	}

}
