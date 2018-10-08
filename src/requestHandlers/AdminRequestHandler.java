package requestHandlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.HomeBean;
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
			request.setAttribute("homes", homes);
			sView = "admin.jsp";
		}
		

		return sView;
	}

}
