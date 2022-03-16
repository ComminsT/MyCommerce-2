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
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;

/**
 * Servlet implementation class InsertSomeCategoryServlet
 */
@WebServlet("/auth/adm/insertCat")
public class InsertSomeCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        
        Category c1 = new Category("Categorie 1");
        Category c2 = new Category("Categorie 2");

        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        categoryDao.add(c1);
        categoryDao.add(c2);
        System.out.println(c1);
        System.out.println(c2);
        
        RequestDispatcher rd = req.getRequestDispatcher(ListCategoryServlet.URL);
        try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }
       



}
