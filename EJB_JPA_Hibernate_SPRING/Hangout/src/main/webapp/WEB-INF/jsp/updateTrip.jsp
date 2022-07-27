<%@page import="bo.Trip"%>
<%@page import="java.time.LocalDate"%>
<%@page import="bo.Participant"%>
<%@page import="bo.Place"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Place> places = (List<Place>) request.getAttribute("places");
Place placeAdd = (Place) session.getAttribute("place");
Trip currentTrip = (Trip) request.getAttribute("trip");
List<Participant> participants = (List<Participant>) request.getAttribute("participants");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier une sortie</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ASSETS/css/style.css">
<link rel='stylesheet' type='text/css'
	href='<%=request.getContextPath()%>/ASSETS/css/add-trip.css'>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.3/moment-with-locales.min.js"></script>
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
				<h1 id="title">Modification d'une sortie</h1>
			</div>
			<div class="table">
				<form action="<%=request.getContextPath()%>/modifier-sortie"
					method="post">
					<div>
						<label for="trip-name" id="trip-name">Nom de la sortie</label> <input
							type="text" name="trip-name"
							value="<%=currentTrip.getTripName()%>" required="required">
					</div>
					<div>
						<select id="select-place" name="select-place"
							onchange="addPlace(this.value);" required="required">
							<option value="">------- Sélectionner un lieu -------</option>
							<%
							if (places.size() > 0) {
								for (Place place : places) {
									if (placeAdd != null && placeAdd.getId() == place.getId()) {
							%>
							<option selected="selected" value="<%=placeAdd.getId()%>"><%=placeAdd.getTitle()%>,<%=placeAdd.getAddress()%></option>
							<%
							} else {
							%>
							<option value="<%=place.getId()%>"><%=place.getTitle()%>,<%=place.getAddress()%></option>
							<%
							}
							}
							%>
							<option value="add-place" style="color: blue;">Ajouter
								un lieu</option>
							<%
							} else {
							%>
							<option value="add-place" style="color: blue;">Ajouter
								un lieu</option>
							<%
							}
							%>
						</select>
					</div>
					<div>
						<label for="date">Date</label> <input type="date" id="date"
							name="date" class="date" data-date=""
							data-date-format="DD MMMM YYYY" lang="fr-FR"
							value="<%=currentTrip.getDate()%>" required="required">
					</div>
					<div>
						<label for="tripHour" id="tripHour">Heure de la sortie</label> <input
							type="time" name="tripHour"
							value="<%=currentTrip.getTripHour()%>" required="required">
					</div>
					<div class="description-control">
						<label for="description" id="description">Description</label>
						<textarea name="description"><%=currentTrip.getDescription()%> required="required"</textarea>
					</div>
					<div>
						<label for="numberMaxOfParticipants" id="numberMaxOfParticipants">Participants
							maximum </label> <input type="number" name="numberMaxOfParticipants"
							value="<%=currentTrip.getNumberMaxOfParticipants()%>"
							required="required">
					</div>
					<div class="multiselect">
						<div class="selectBox" onclick="showCheckboxes()">
							<select>
								<option>Choisir des participants</option>
							</select>
							<div class="overSelect"></div>
						</div>
						<div id="checkboxes">
							<%
							for (Participant participant : participants) {
							%>
							<label for="<%=participant.getId()%>"> <input
								name="select-participant" value="<%=participant.getId()%>"
								type="checkbox" id="<%=participant.getId()%>" /><%=participant.getUsername()%>
							</label>
							<%
							}
							%>
						</div>
					</div>
					<div>
						<button type="submit" id="add-trip-btn" name="add-trip-btn">Modifier
							la sortie</button>
					</div>
				</form>
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
		src="<%=request.getContextPath()%>/ASSETS/js/add-trip.js"></script>
</body>
</html>