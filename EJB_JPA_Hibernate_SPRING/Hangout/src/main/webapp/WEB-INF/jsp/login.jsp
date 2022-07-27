<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/ASSETS/css/style.css">
</head>
<body>
	<div class="flex-container">
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
		<main>
			<div class="page-title">
				<h1 id="title">Connexion à Hangout</h1>
			</div>
			<div class="table">
				<form action="<%=request.getContextPath()%>/connexion" method="post">
					<div>
						<label for="email" id="email">Email</label> <input type="email"
							name="email" required="required">
					</div>
					<div>
						<label for="password" id="password">Mot de passe</label> <input
							type="password" name="password" required="required">
					</div>
					<div>
						<button type="submit" id="connection-btn" name="connection-btn">Connexion</button>
					</div>
					<div>
						<a href="<%=request.getContextPath()%>/creation-compte">Créer
							un compte</a>
					</div>
					<%
					if (error != null) {
					%>
					<div>
						<h2><%=error%></h2>
					</div>
					<%
					}
					%>
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