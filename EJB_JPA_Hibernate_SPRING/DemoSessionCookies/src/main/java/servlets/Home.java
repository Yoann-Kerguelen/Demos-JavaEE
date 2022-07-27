package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie1 = new Cookie("user2", "root2");
		response.addCookie(cookie1);
		
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		
		if(cookies!=null) { //1er visit
			//Cookie cookie = new Cookie("user", "root");
			//response.addCookie(cookie);
			//response.getWriter().append("1 er visit");
			for (Cookie c : cookies) {
				if(c.getName().equals("user")) {
					flag =true;
					break;
				}
			}
		}
		
		if(flag == true) {
			response.getWriter().print("<h1>Vous êtes un habitué</h1>");
		}else {
			Cookie cookie = new Cookie("user", "root");
			response.addCookie(cookie);
			response.getWriter().print("<h1>1 er visit</h1>");
		}
		
		
		
		/*else {
			response.getWriter().append("vous etes un habitué");
		}
		
		
		Cookie cookie = new Cookie("prenom", "Yo");
		response.addCookie(cookie);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie2 : cookies) {
			System.out.println(cookie2.getName() + ":" + cookie2.getValue());
		}
		response.sendRedirect("https://pub.dev/");
		Cookie cookie = new Cookie("Connection", "1");
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cook : cookies) {
			System.out.println(cook.getName()+cook.getPath()+cook.getValue());
		}*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
