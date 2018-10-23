package requestHandlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import beans.Home;
import datastore.Datastore;

public class SearchResultsRequestHandler implements RequestHandler{
	
	private Datastore datastore;

	public SearchResultsRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/searchResults") || path.equals("/searchResults.html")) {
			List<Home> homes;
			try {
				homes = (List<Home>) datastore.getHomes();
				request.setAttribute("homes", homes);

			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sView = "searchResults.jsp";
		}

		return sView;
	}

}
