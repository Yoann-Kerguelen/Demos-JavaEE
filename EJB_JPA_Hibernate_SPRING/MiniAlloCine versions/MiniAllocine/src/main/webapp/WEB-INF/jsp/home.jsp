<%@page import="fr.miniallocine.bo.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Item> items = (List<Item>) request.getAttribute("items"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/style.css" >
<title>Accueil</title>
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
				<h1>Liste films & séries</h1>
			</div>
			<div class="table">
				<form action="<%= request.getContextPath() %>/" method="post" >
					<table>
						<thead>
							<tr>
								<th>#</th>
								<th>Titre</th>
								<th>Catégorie</th>
								<th>Type</th>
								<th>Date</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<% for(Item item :items){ %>
								<tr>
									<td><%=item.getId() %></td>
									<td><%=item.getTitle() %></td>
									<td><%=item.getCategory() %></td>
									<td><%=item.getType() %></td>
									<td><%=item.getDate() %></td>
									<td><button name="supp" value="<%=item.getId() %>" onclick="confirm('Voulez-vous vraiment supprimer ?');" type="submit" >Supprimer</button> </td>
								</tr>						
							<% } %>
						</tbody>
					</table>
				</form>
			</div>
		</main>
		<footer>
			<p> Mini-Allociné &copy; <%=LocalDate.now().getYear() %> </p>				
		</footer>
	</div>
</body>
</html>