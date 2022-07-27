package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.ParticipantSession;
import ejb.PlaceSession;
import ejb.TripSession;

@WebServlet("/accueil")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private TripSession tripSession;

	@EJB
	private PlaceSession placeSession;

	@EJB
	private ParticipantSession participantSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("current-user-id") != null) {
				request.setAttribute("trips", tripSession.getAllTrips());
				request.setAttribute("places", placeSession.getAllPlaces());
				request.setAttribute("participants", participantSession.getAllParticipants());
				request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/connexion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("update") != null) {
				HttpSession session = request.getSession();
				session.setAttribute("trip-id-to-update", Integer.valueOf(request.getParameter("update")));
				response.sendRedirect(request.getContextPath() + "/modifier-sortie");
			} else if (request.getParameter("delete") != null) {
				tripSession.deleteTrip(Integer.valueOf(request.getParameter("delete")));
				response.sendRedirect(request.getContextPath() + "/accueil");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
