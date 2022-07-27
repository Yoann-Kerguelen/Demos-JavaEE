<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/style.css" >
<title>Ajouter série et film</title>
</head>
<body>
	<div class="flex-container">
		<header> 
			<div class="logo">
				<span> Mini-Allociné </span>
			</div>
			<nav>
				<ul>
					<li><a href="<%= request.getContextPath() %>">Accueil</a></li>
					<li><a href="<%= request.getContextPath() %>/serie-film/ajouter">Ajouter film et série</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<div class="page-title">
				<h1>Ajouter film & série</h1>
			</div>
			<form class="add-form" action="<%=request.getContextPath() %>/serie-film/ajouter" method="post">
				
				<div class="form-control">
					<label>Type</label>
					<select name="type">
						<option>Film</option>
						<option>Série</option>
					</select>
				</div>
				<div class="form-control">
					<label>Catégorie</label>
					<select name="category">
						<option>Action</option>
						<option>Science-Fiction</option>
						<option>Comédie</option>
					</select>
				</div>	
				<div class="form-control">
					<label>Titre</label>
					<input type="text" name="title">
				</div>		
				<div class="form-control">
					<label>Description</label>
					<textarea rows="" cols="" name="description"></textarea>
				</div>											
				<div class="form-control">
					<label>Date de sortie</label>
					<input type="date" name="date">
				</div>										
				<div class="form-control">
					<button type="submit">Ajouter</button>
				</div>				
			</form>
		</main>
		<footer>
			<p> Mini-Allociné &copy; <%=LocalDate.now().getYear() %> </p>				
		</footer>
	</div>
</body>
</html>