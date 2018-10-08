package javaPackage;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import requestHandlers.IndexRequestHandler;
import requestHandlers.MessagesRequestHandler;
import requestHandlers.RequestHandler;
import requestHandlers.SearchResultsRequestHandler;
import requestHandlers.BookingsRequestHandler;
/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

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
		this.config = config;
		handlerHash.put("/index.html", new IndexRequestHandler());
		handlerHash.put("/searchResults.html", new SearchResultsRequestHandler());
		handlerHash.put("/messages.html", new MessagesRequestHandler());
		handlerHash.put("/bookings.html", new BookingsRequestHandler());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();

		RequestHandler requestHandler = (RequestHandler) handlerHash.get(path);
		if (requestHandler == null) {
			request.getRequestDispatcher("notFound.jsp").forward(request, response);
		} else {
			String sView = requestHandler.handleRequest(request, response);
			request.getRequestDispatcher(sView).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		RequestHandler requestHandler = (RequestHandler) handlerHash.get(path);
		String sView = requestHandler.handleRequest(request, response);

		request.getRequestDispatcher(sView).forward(request, response);

	}

}
