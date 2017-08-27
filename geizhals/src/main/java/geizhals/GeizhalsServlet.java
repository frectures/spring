package geizhals;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "")
public class GeizhalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// fill the model
		request.setAttribute("greetees", new String[] { "Alice", "Bob", "Carol" });

		// forward to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Geizhals.jsp");
		dispatcher.forward(request, response);
	}
}
