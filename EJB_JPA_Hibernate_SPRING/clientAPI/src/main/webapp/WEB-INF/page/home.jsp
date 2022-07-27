<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>
</head>
<body>
	<h1>Acceuil</h1>

	<div class="search">
		<label>Recherche</label> <input type="text" id="search">
		<button type="button" onclick="searchFetch();">Recherche</button>
	</div>

	<div>
		<p>
			Titre : <span id="title"> </span>
		</p>
		<p>
			Prix : <span id="price"> </span>
		</p>
	</div>

	<%-- <div>
		<label>
			<button type="button" onclick="getAllArticles();">Récupérer
				tous les articles</button>
		</label>
	</div>
	<input type="hidden" id="articles">
	<%
	 
	%>
	<div class="page-title" id="liste-articles" hidden="true">
		<h1>Liste des articles</h1>
	</div>
	<div class="table">
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th>prix</th>

				</tr>
			</thead>
			<tbody>
				<%
				for (Item item : items) {
				%>
				<tr>
					<td><%=item.id%></td>
					<td><%=item.nom%></td>
					<td><%=item.prix%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div> --%>

	<script>
	var titleNode = document.querySelector('#title');
	var priceNode = document.querySelector('#price');
		//methode 1 : XMLHttpRequest
		function search() {
			var idFieldNode = document.querySelector('#search');

			var xhttp = new XMLHttpRequest();

			xhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					var article = JSON.parse(xhttp.response);				
					titleNode.innerText = article.nom;	
					priceNode.innerText = article.prix;
				}

			}

			xhttp.open("GET", "http://localhost:8080/DemoAPIRest/api/articles/"
					+ idFieldNode.value)
			xhttp.setRequestHeader("Accept", "application/json");
			//envoie http
			xhttp.send();
		}

		//methode 2 : fetch js
		function searchFetch() {
			var idFieldNode = document.querySelector('#search');

			fetch("http://localhost:8080/DemoAPIRest/api/articles/"+ idFieldNode.value)
			.then(response => response.json())
			.then(data => {
				titleNode.innerText = data.nom;
				priceNode.innerText = data.prix;
			});
		}
		
		function getAllArticles(){
			fetch("http://localhost:8080/DemoAPIRest/api/articles/all")
			.then(response => response.json())
			.then(data => {
				var listArticles = document.querySelector("liste-articles");
				listArticles.setAttribute("hidden", "false");
			});
		}
		
		
	</script>
</body>
</html>