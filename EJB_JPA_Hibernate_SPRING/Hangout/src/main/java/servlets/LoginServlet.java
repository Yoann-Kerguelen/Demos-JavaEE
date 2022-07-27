package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Participant;
import ejb.ParticipantSession;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParticipantSession participantSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("current-user-id");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			List<Participant> participants = participantSession.getAllParticipants();

			if (participants.size() > 0) {
				for (Participant participant : participants) {
					if (participant.getEmail().equals(email) && participant.getPassword().equals(password)) {
						HttpSession session = request.getSession();
						session.setAttribute("current-user-id", participant.getId());
						response.sendRedirect(request.getContextPath() + "/ajouter-sortie");
					}
				}
				String error = "Email ou mot de passe invalide, veuillez réessayer.";
				request.setAttribute("error", error);
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/creation-compte");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
