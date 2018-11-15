package requestHandlers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;

import java.util.Collections;
import java.util.List;

import entities.Message;
import entities.User;

public class MessagesRequestHandler implements RequestHandler {

	private Datastore dataStore;

	public MessagesRequestHandler() {
		dataStore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/messages.html")) {
			sView = "messages.jsp";
		}
		List<Message> messages = (List<Message>) dataStore.getMessages();
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);
		return sView;
	}

}
