package javaPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaPackage.RequestHandlers.MessagesRequestHandler;
import javaPackage.RequestHandlers.RequestHandler;
import javaPackage.RequestHandlers.SearchResultsRequestHandler;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Hash table of RequestHandler instances, keyed by request URL
		  private Map handlerHash = new HashMap();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	    handlerHash.put("/searchResults.html", new SearchResultsRequestHandler());
	    handlerHash.put("/messages.html", new MessagesRequestHandler());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
		  
		  String path = request.getServletPath();
		  RequestHandler requestHandler = (RequestHandler) handlerHash.get(path);
		  if (requestHandler == null) {
			  request.getRequestDispatcher("notFound.jsp").forward(request, response);
		  }
		  else {
			  String sView = requestHandler.handleRequest(request, response);
			  request.getRequestDispatcher(sView).forward(request, response);
		  }
		  
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
