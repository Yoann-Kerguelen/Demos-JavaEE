<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Integer currentUser = (Integer) session.getAttribute("current-user-id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer un compte</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ASSETS/css/style.css">
</head>
<body>
	<div class="flex-container">
		<%
		if (currentUser != null) {
		%>
		<header>
			<div class="logo">
				<span><a style="color: white;"
					href="<%=request.getContextPath()%>/accueil">Hangout</a></span>
			</div>
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/accueil">Accueil</a></li>
					<li><a href="<%=request.getContextPath()%>/connexion">Connexion</a></li>
					<li><a href="<%=request.getContextPath()%>/creation-compte">Créer
							un compte</a></li>
				</ul>
			</nav>
		</header>
		<%
		} else {
		%>
		<header>
			<div class="logo">
				<span style="color: white;">Hangout</span>
			</div>
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/connexion">Connexion</a></li>
					<li><a href="<%=request.getContextPath()%>/creation-compte">Créer
							un compte</a></li>
				</ul>
			</nav>
		</header>
		<%
		}
		%>
		<main>
			<div class="page-title">
				<h1 id="title">Création d'un compte Hangout</h1>
			</div>
			<div class="table">
				<form action="<%=request.getContextPath()%>/creation-compte"
					method="post">
					<div>
						<label for="firstname" id="firstname">Prénom</label> <input
							type="text" name="firstname" required="required">
					</div>
					<div>
						<label for="lastname" id="lastname">Nom</label> <input type="text"
							name="lastname" required="required">
					</div>
					<div>
						<label for="age" id="age">Age</label> <input type="number"
							name="age" required="required" min="18">
					</div>
					<div>
						<label for="username" id="username">Pseudo</label> <input
							type="text" name="username" required="required">
					</div>
					<div>
						<label for="email" id="email">Email</label> <input type="email"
							name="email" required="required">
					</div>
					<div>
						<label for="password" id="password">Mot de passe</label> <input
							type="password" name="password" required="required">
					</div>
					<div>
						<button type="submit" id="register-btn" name="register-btn">Créer
							votre compte Hangout</button>
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