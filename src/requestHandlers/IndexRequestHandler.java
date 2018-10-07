package requestHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/index.html")) {
			sView = "index.jsp";
		}

		return sView;
	}

}
