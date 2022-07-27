<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>
</head>
<body>
	<h1 align="center">Chi-Fou-Mi</h1>
	<h3 style="color: red;" align="center">Faites un choix</h3>
	<div align="center">
		<form action="<%=request.getContextPath()%>/resultat" method="post">
			<input type="submit" name="userChoice" value="CHI" />
			<input type="submit" name="userChoice" value="FOU" />
			<input type="submit" name="userChoice" value="MI" />
		</form>
	</div>
</body>
</html>