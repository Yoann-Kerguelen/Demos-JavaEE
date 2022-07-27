package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.PostSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PostSession ps;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Post p = new Post(); p.setTitle("Formation EJB on aime pas SYMFONY");
		 * p.setContent("Contennnnnnnnnnttt"); ps.addPost(p);
		 */
		// response.getWriter().append(ps.getPost(1).getTitle());
		request.setAttribute("article", ps.getAllPosts());
		request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
		// response.getWriter().append(ps.getAllPosts().get(0).getTitle());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
