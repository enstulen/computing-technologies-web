package requestHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;
import java.util.List;

import beans.Message;

public class MessagesRequestHandler implements RequestHandler{
	
	private Datastore dataStore;
	
	public MessagesRequestHandler(){
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
		request.setAttribute("Messages",(List<Message>) dataStore.getMessages());

		return sView;
	}

}
