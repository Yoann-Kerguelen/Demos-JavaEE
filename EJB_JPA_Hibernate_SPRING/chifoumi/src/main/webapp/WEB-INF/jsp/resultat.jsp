<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
</head>
<body>
	<h1 align="center">Résultat du CHI-FOU-MI</h1>
	<nav>
		<ul>
			<li>CHI gagne contre MI</li>
			<li>FOU gagne contre CHI</li>
			<li>MI gagne contre FOU</li>
		</ul>
	</nav>
	<h3 align="center" style="color: green;">
		L'utilisateur a choisi :
		<%=request.getAttribute("userChoice")%></h3>
	<h3 align="center" style="color: red;">
		Le serveur a choisi :
		<%=request.getAttribute("serverChoice")%></h3>
	<h3 align="center" style="border: solid; border-color: purple;">
		<span
			style=<%=(request.getAttribute("winner") == "Egalité") ? "color: pink;"
		: (request.getAttribute("winner") == "Le serveur") ? "color: red;" : "color: green;"%>>
			<%=request.getAttribute("winner")%></span>
		<%=(request.getAttribute("winner") == "Egalité") ? " rejouer !" : " gagne la partie !!"%>
	</h3>
	<div align="center">
		<button onclick="location.href='index.jsp'" type="button"
			style="color: pink;">REJOUER</button>
	</div>
</body>
</html>