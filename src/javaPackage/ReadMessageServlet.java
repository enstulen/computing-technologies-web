package javaPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.User;

/**
 * Servlet implementation class ReadMessageQueueBrowserServlet
 */
@WebServlet({ "/ReadMessageServlet", "/ReadMessageQueue.html" })
public class ReadMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Inject the connectionFactory using annotations
	@Resource(mappedName = "tiwConnectionFactory")
	private ConnectionFactory tiwconnectionfactory;

	@Resource(mappedName = "tiwqueue")
	// Inject the queue using annotations
	private Queue queue;

	private Datastore datastore;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadMessageServlet() {
		super();
		this.datastore = Datastore.getInstance();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			doPost(request, response);
		} catch (Exception e) {
			System.out.println("JHC ***************************************Error in doGet: " + e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try {
			Connection connection = tiwconnectionfactory.createConnection();
			Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

			connection.start();
			User currentUser = (User) request.getSession().getAttribute("user");
			String selector = "receiver = " + "'" + currentUser.getEmail() + "'";
			MessageConsumer consumer = session.createConsumer(queue, selector);
			Message message = null;
			while (true) {
			
				message = consumer.receive(2000);
				if (message instanceof TextMessage) {
					TextMessage m = (TextMessage) message;
					entities.Message newMessage = new entities.Message();
					newMessage.setText(m.getText());
					newMessage.setReciever(currentUser);
					newMessage.setSender(datastore.findUser(m.getStringProperty("sender")));
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					newMessage.setTime_stamp(timestamp);
					datastore.createNewMessage(newMessage);
					out.println("Sender : " + m.getStringProperty("sender"));
					out.println("Receiver : " + m.getStringProperty("receiver"));
					out.println("Message : " + m.getText());
				} else {
					out.println("No messages");
					out.println("\n");
					break;
				}
			}

			connection.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("JHC *************************************** Error in doPost: " + e);
		}
		out.println("</body>");
		out.println("</html>");

	}

}
