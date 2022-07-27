package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Participant;
import ejb.ParticipantSession;

@WebServlet("/creation-compte")
public class RegisterParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParticipantSession participantSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/registerParticipant.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int age = Integer.valueOf(request.getParameter("age"));
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			Participant participant = new Participant();

			participant.setFistName(firstname);
			participant.setLastName(lastname);
			participant.setAge(age);
			participant.setUsername(username);
			participant.setEmail(email);
			participant.setPassword(password);

			participantSession.addParticipant(participant);

			response.sendRedirect(request.getContextPath() + "/connexion");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
