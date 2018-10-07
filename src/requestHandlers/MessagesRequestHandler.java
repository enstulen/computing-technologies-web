package requestHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;
import java.util.List;

import beans.MessageBean;

public class MessagesRequestHandler implements RequestHandler{
	
	private Datastore DataStore;
	
	public MessagesRequestHandler(){
		DataStore = new Datastore();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/messages.html")) {
			sView = "messages.jsp";
		}
		request.setAttribute("Messages",(List<MessageBean>) DataStore.getMessages());

		return sView;
	}

}
