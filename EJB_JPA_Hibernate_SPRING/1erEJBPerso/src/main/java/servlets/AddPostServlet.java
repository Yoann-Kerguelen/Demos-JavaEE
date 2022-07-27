package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Post;
import ejb.PostSession;
import helper.Check;

/**
 * Servlet implementation class AddPostServlet
 */
@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PostSession ps;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("");
		String content = request.getParameter("content");

		try {
			Check.checkRequiredField(title, "Titre");
			Check.checkRequiredField(content, "Contenu");

			Post p = new Post();

			p.setTitle(title);
			p.setContent(content);

			ps.addPost(p);

			response.sendRedirect(request.getContextPath() + "/home");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
