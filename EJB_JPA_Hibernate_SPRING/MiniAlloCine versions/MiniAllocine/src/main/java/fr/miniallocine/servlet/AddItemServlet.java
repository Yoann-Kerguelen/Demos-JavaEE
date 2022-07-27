package fr.miniallocine.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.miniallocine.bo.Item;
import fr.miniallocine.dao.Factory;


@WebServlet("/serie-film/ajouter")
public class AddItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/addItem.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String description = request.getParameter("description");
		
		try {
			checkRequiredField(type, "Type");
			checkRequiredField(category, "Catégorie");
			checkRequiredField(title, "Titre");
			
			Factory.getItemDAO().insert( new Item(title, category, type, description, LocalDate.parse(date)) );
			response.sendRedirect(request.getContextPath());// redirect to home
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void checkRequiredField(String field,String msg) throws Exception {
		if(field!=null && field.isBlank()) {
			throw new Exception("Le champs "+msg+" ne pas etre vide");
		}
	}	

}
