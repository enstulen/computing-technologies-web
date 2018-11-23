package requestHandlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.Home;
import entities.User;

public class ManageHomeRequestHandler implements RequestHandler {
	
	private Datastore datastore;

	public ManageHomeRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sView = "";
		
		List<Home> homes;
		User currentUser = (User) request.getSession().getAttribute("user");

		homes = (List<Home>) datastore.getHomesForHost(currentUser);
		
		request.setAttribute("homes", homes);

		sView = "managehome.jsp";
		
		return sView;


	}

}
