package javaPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
import requestHandlers.AdminRequestHandler;
import requestHandlers.BookingDetailsRequestHandler;
import requestHandlers.IndexRequestHandler;
import requestHandlers.ManageHomeRequestHandler;
import requestHandlers.MessagesRequestHandler;
import requestHandlers.ReadMessagesRequestHandler;
import requestHandlers.RequestHandler;
import requestHandlers.SearchResultsRequestHandler;
import requestHandlers.SendMessagesRequestHandler;
import requestHandlers.StatusMessagesRequestHandler;
import requestHandlers.BookingsRequestHandler;
import requestHandlers.DetailsRequestHandler;
import requestHandlers.EditNewRequestHandler;

/**
 * Servlet implementation class ControllerServlet
 */
@MultipartConfig(location="/Users/enstulen2/git/computing-technologies-web/WebContent/images", fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
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
		handlerHash.put("/admin.html", new AdminRequestHandler());
		handlerHash.put("/booking-details.html", new BookingDetailsRequestHandler());
		handlerHash.put("/bookings.html", new BookingsRequestHandler());
		handlerHash.put("/details.html", new DetailsRequestHandler());
		handlerHash.put("/edit-new-home.html", new EditNewRequestHandler());
		handlerHash.put("/sendMessage.html", new SendMessagesRequestHandler());
		handlerHash.put("/readmessage.html", new ReadMessagesRequestHandler());
		handlerHash.put("/edit-new-booking.html", new EditNewRequestHandler());
		handlerHash.put("/edit-new-user.html", new EditNewRequestHandler());
		handlerHash.put("/edit-new-message.html", new EditNewRequestHandler());
		handlerHash.put("/mark-as-read.html", new StatusMessagesRequestHandler());
		handlerHash.put("/managehome.html", new ManageHomeRequestHandler());

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

		if (request.getParameter("IniciaSesion") != null) {
			System.out.println("You made it");
		}
		request.getRequestDispatcher(sView).forward(request, response);

	}

}
