package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Trip;
import ejb.ParticipantSession;
import ejb.PlaceSession;
import ejb.TripSession;

@WebServlet("/modifier-sortie")
public class UpdateTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlaceSession placeSession;

	@EJB
	private ParticipantSession participantSession;

	@EJB
	private TripSession tripSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("current-user-id") != null) {
				int tripId = (int) session.getAttribute("trip-id-to-update");
				request.setAttribute("trip", tripSession.getTrip(tripId));
				request.setAttribute("places", placeSession.getAllPlaces());
				request.setAttribute("participants", participantSession.getAllParticipants());
				request.getRequestDispatcher("/WEB-INF/jsp/updateTrip.jsp").forward(request, response);
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
			String tripName = request.getParameter("trip-name");
			String selectPlace = request.getParameter("select-place");
			String date = request.getParameter("date");
			String tripHour = request.getParameter("tripHour");
			String description = request.getParameter("description");
			int numberMaxOfParticipants = Integer.valueOf(request.getParameter("numberMaxOfParticipants"));
			String[] selectParticipant = request.getParameterValues("select-participant");

			HttpSession session = request.getSession();
			int createBy = (int) session.getAttribute("current-user-id");
			int tripId = (int) session.getAttribute("trip-id-to-update");

			Trip trip = new Trip();

			trip.setTripName(tripName);
			trip.setCreateBy(Integer.valueOf(createBy));
			trip.setDescription(description);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date d = formatter.parse(date);
			DateFormat dateFormat = new SimpleDateFormat("EEEEE dd MMMMM yyyy", Locale.FRENCH);
			String strDate = dateFormat.format(d);

			trip.setDate(strDate);
			trip.setTripHour(tripHour);
			trip.setParticipants(selectParticipant);
			trip.setNumberMaxOfParticipants(numberMaxOfParticipants);
			trip.setPlace(selectPlace);

			tripSession.updateTrip(trip, tripId);

			response.sendRedirect(request.getContextPath() + "/accueil");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
