package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Place;
import ejb.PlaceSession;

@WebServlet("/ajouter-lieu")
public class AddPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlaceSession placeSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("current-user-id") != null) {
				request.getRequestDispatcher("/WEB-INF/jsp/addPlace.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/connexion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String titlePlace = request.getParameter("title-place");
			String address = request.getParameter("address");

			Place place = new Place();

			place.setTitle(titlePlace);
			place.setAddress(address);

			placeSession.addPlace(place);

			HttpSession session = request.getSession();
			session.setAttribute("place", place);
			response.sendRedirect(request.getContextPath() + "/ajouter-sortie");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
