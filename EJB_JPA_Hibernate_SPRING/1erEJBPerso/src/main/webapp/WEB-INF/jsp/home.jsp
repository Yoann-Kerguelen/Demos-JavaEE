<%@page import="bo.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Titre</th>
				<th>Résumé</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Post> posts = (List<Post>) request.getAttribute("articles");
			%>
			<%
			for (Post post : posts) {
			%>
			<tr>
				<td><%=post.getId()%></td>
				<td><a
					href="<%=request.getContextPath()+"/PostServlet"%><%=post.getTitle()%>"></a></td>
				<td><%=post.getContent()%></td>
				<td>----</td>
			</tr>
			<%
			}
			%>

		</tbody>

	</table>

</body>
</html>