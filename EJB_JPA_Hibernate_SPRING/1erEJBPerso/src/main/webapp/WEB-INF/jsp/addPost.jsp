<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un article</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/AddPostServlet"
		method="get">
		<div>
			<label>Titre</label> <input type="text" name="title">
		</div>
		<div>
			<label>Contenu</label>
			<textarea type="text" name="content"></textarea>
		</div>
		<div>
			<button type="submit" name="btn">Ajouter un article</button>
		</div>
	</form>
</body>
</html>