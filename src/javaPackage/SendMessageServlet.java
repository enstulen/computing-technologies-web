package javaPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Inject the connectionFactory using annotations
	@Resource(mappedName = "tiwConnectionFactory")
	private ConnectionFactory tiwconnectionfactory;
	// Inject the queue using annotations
	@Resource(mappedName = "tiwqueue")
	private Queue queue;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			Connection connection = tiwconnectionfactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			MapMessage message = session.createMapMessage();
			message.setString("Sender",request.getParameter("sender"));
			message.setString("Receiver", request.getParameter("receiver"));
			message.setString("Message", request.getParameter("message"));
			messageProducer.send(message);
			messageProducer.close();
			session.close();
			connection.close();
			// out.println(" Menssage sent </BR>");

		} catch (javax.jms.JMSException e) {
			System.out.println("JHC *************************************** Error in doPost: " + e);
			System.out.println(
					"JHC *************************************** Error MQ: " + e.getLinkedException().getMessage());
			System.out.println(
					"JHC *************************************** Error MQ: " + e.getLinkedException().toString());
			out.println(" Error when sending the message</BR>");

		} catch (Exception e) {
			System.out.println("JHC *************************************** Error in doPost: " + e.toString());
			out.println(" Error when sending the message</BR>");

		}
	}

	public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		try {
			doPost(request, response);
		} catch (Exception e) {
			System.out.println("JHC ***************************************Error in doGet: " + e);
		}

	}

}
