package requestHandlers;

import java.io.IOException;

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

public class SendMessagesRequestHandler implements RequestHandler {

	private Datastore dataStore;

	private ConnectionFactory connectionFactory;
	private Queue queue;

	public SendMessagesRequestHandler(ConnectionFactory connection, Queue queue) {
		dataStore = Datastore.getInstance();
		this.connectionFactory = connection;
		this.queue = queue;

	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/sendMessage.html")) {
			sView = "messages.jsp";
		}
		try {

			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message = session.createTextMessage();
			User sender = (User) request.getSession().getAttribute("user");
			message.setStringProperty("sender", sender.getEmail());
			message.setStringProperty("receiver", request.getParameter("receiver"));
			message.setText(request.getParameter("message"));
			messageProducer.send(message);
			messageProducer.close();
			session.close();
			connection.close();
		} catch (javax.jms.JMSException e) {
			System.out.println("JHC *************************************** Error in doPost: " + e);
			System.out.println(
					"JHC *************************************** Error MQ: " + e.getLinkedException().getMessage());
			System.out.println(
					"JHC *************************************** Error MQ: " + e.getLinkedException().toString());

		} catch (Exception e) {
			System.out.println("JHC *************************************** Error in doPost: " + e.toString());

		}
		List<Message> messages = (List<Message>) dataStore.getMessages();
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);
		return sView;
	}

}
