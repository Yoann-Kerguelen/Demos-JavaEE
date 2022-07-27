<%@page import="bo.Participant"%>
<%@page import="bo.Place"%>
<%@page import="java.time.LocalDate"%>
<%@page import="bo.Trip"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Trip> trips = (List<Trip>) request.getAttribute("trips");
List<Place> places = (List<Place>) request.getAttribute("places");
List<Participant> participants = (List<Participant>) request.getAttribute("participants");
int currentUser = (int) session.getAttribute("current-user-id");
int i = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ASSETS/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ASSETS/css/home.css">
<title>Accueil</title>
</head>
<body>
	<div class="flex-container">
		<header>
			<div class="logo">
				<span><a style="color: white;"
					href="<%=request.getContextPath()%>/accueil">Hangout</a></span>
			</div>
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/accueil">Accueil</a></li>
					<li><a href="<%=request.getContextPath()%>/ajouter-sortie">Ajouter
							une sortie</a></li>
					<li><a href="<%=request.getContextPath()%>/ajouter-lieu">Ajouter
							un lieu</a></li>
				</ul>
			</nav>
			<div class="disconnect">
				<span><a style="color: white;"
					href="<%=request.getContextPath()%>/connexion">Déconnexion</a></span>
			</div>
		</header>
		<main>
			<div class="page-title">
				<h1>Accueil Hangout</h1>
			</div>
			<div class="page-title">
				<h2>Liste des sorties sur Hangout</h2>
			</div>
			<div class="table">

				<table>
					<thead>
						<tr>
							<th>Titre</th>
							<th>Description</th>
							<th>Lieu</th>
							<th>Date</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Trip trip : trips) {
						%>
						<tr>
							<td><%=trip.getTripName()%></td>
							<td><%=trip.getDescription()%></td>
							<%
							for (Place place : places) {
								if (place.getId() == Integer.valueOf(trip.getPlace())) {
							%>
							<td><%=place.getTitle()%>,<%=place.getAddress()%></td>
							<%
							}
							}
							%>
							<td><%=trip.getDate()%></td>
							<td>
								<button class="modal-button" href="#myModal<%=i%>">Afficher</button>
								<!-- The Modal -->
								<div id="myModal<%=i%>" class="modal">

									<!-- Modal content -->
									<div class="modal-content">
										<div class="modal-header">
											<span class="close">x</span>
											<h2><%=trip.getTripName()%></h2>
											<%
											for (Place place : places) {
												if (place.getId() == Integer.valueOf(trip.getPlace())) {
											%>
											<h5><%=place.getTitle()%>,<%=place.getAddress()%></h5>
											<%
											}
											}
											%>
											<h6>
												Nombre de participants maximun :
												<%=trip.getNumberMaxOfParticipants()%></h6>
										</div>
										<div class="modal-body">
											<p>
												<span>Date et heure :</span> <span><%=trip.getDate()%>
													à <%=trip.getTripHour()%></span>
											</p>
											<p style="color:purple;" >
												<%=trip.getDescription()%>
											</p>
											<span>Participants : </span>
											<%
											for (String participantId : trip.getParticipants()) {
												for (Participant participant : participants) {
													if (participant.getId() == Integer.valueOf(participantId)) {
											%>
											<span><%=participant.getUsername()%></span>
											<%
											}
											}
											}
											%>
										</div>
										<div class="modal-footer">
											<%
											for (Participant participant : participants) {
												if (participant.getId() == Integer.valueOf(trip.getCreateBy())) {
											%>
											<h4>
												Créé par :<%=participant.getUsername()%>
											</h4>
											<%
											}
											}
											%>
										</div>
									</div>
								</div> <%
								 if (currentUser == trip.getCreateBy()) {
								 %>
								<form action="<%=request.getContextPath()%>/accueil"
									method="post">
									<button name="update" value="<%=trip.getId()%>" type="submit">Modifier</button>

									<button name="delete" value="<%=trip.getId()%>"
										onclick="return confirm('Voulez-bous vraiment supprimer cettre sortie ?');"
										type="submit">Supprimer</button>
								</form> <%
								 }
								 %>
							</td>
						</tr>
						<%
						i++;
						}
						%>
					</tbody>
				</table>

			</div>
		</main>
		<footer>
			<p>
				Hangout &copy;
				<%=LocalDate.now().getYear()%>
			</p>
		</footer>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ASSETS/js/home.js"></script>
</body>
</html>