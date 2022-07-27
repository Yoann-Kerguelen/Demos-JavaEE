<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un lieu</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ASSETS/css/style.css">
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
				<h1 id="title">Ajouter un lieu</h1>
			</div>
			<div class="table">
				<form action="<%=request.getContextPath()%>/ajouter-lieu"
					method="post">
					<div>
						<label for="title-place" id="title-place">Nom du Lieu</label> <input
							type="text" name="title-place" required="required">
					</div>
					<div>
						<label for="address" id="address">adresse</label> <input
							type="text" name="address" required="required">
					</div>
					<div>
						<button type="submit" id="add-place-btn" name="add-place-btn">Ajouter
							le lieu</button>
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
</body>
</html>