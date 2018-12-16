package requestHandlers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;

import java.util.Collections;
import java.util.List;

import entities.User;

public class ReadMessagesRequestHandler implements RequestHandler {

	private Datastore datastore;

	public ReadMessagesRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		
		User currentUser = (User) request.getSession().getAttribute("user");

		String path = request.getServletPath();
		if (path.equals("/readmessage.html")) {
			sView = "messages.jsp";
		}
		List<entities.Message> messages = (List<entities.Message>) datastore.getMessagesForUser(currentUser);
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);
		return sView;
	}

}
