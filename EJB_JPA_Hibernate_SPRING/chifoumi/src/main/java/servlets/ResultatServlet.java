package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resultat")
public class ResultatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] choices = { "CHI", "FOU", "MI" };
		String serverChoice = choices[(int) (Math.random() * choices.length)];
		// System.out.println(serverChoice);

		String userChoice = request.getParameter("userChoice");
		// System.out.println(userChoice);

		request.setAttribute("userChoice", userChoice);
		request.setAttribute("serverChoice", serverChoice);

		String res = "";

		switch (userChoice) {
		case "CHI":
			switch (serverChoice) {
			case "CHI":
				res = "Egalité";
				break;
			case "FOU":
				res = "Le serveur";
				break;
			case "MI":
				res = "L'utilisateur";
				break;
			}
			break;
		case "FOU":
			switch (serverChoice) {
			case "CHI":
				res = "L'utilisateur";
				break;
			case "FOU":
				res = "Egalité";
				break;
			case "MI":
				res = "Le serveur";
				break;
			}
			break;
		case "MI":
			switch (serverChoice) {
			case "CHI":
				res = "Le serveur";
				break;
			case "FOU":
				res = "L'utilisateur";
				break;
			case "MI":
				res = "Egalité";
				break;
			}
			break;
		}

		request.setAttribute("winner", res);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/resultat.jsp");
		rd.forward(request, response);
	}

}
