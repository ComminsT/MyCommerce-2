package com.mycommerce.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.model.Category;

/**
 * Servlet implementation class updateCategoryServlet
 */
@WebServlet(updateCategoryServlet.URL)
public class updateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String URL ="/update-category";
	
	CategoryDao categoryDao = DaoFactory.getCategoryDao();
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Category c = categoryDao.findById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("category", c);
		
		System.out.println("id : "+ request.getParameter("id"));
		
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateCategory.jsp");
        rd.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Category c = new Category(Long.parseLong(request.getParameter("id")),request.getParameter("lib"));
		categoryDao.update(c);

        RequestDispatcher rd = request.getRequestDispatcher("/auth/adm/list-category");
        rd.forward(request, response);
	}	


}
