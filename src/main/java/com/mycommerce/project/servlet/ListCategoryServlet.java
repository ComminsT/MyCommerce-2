package com.mycommerce.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ListCategoryServlet
 */
@WebServlet(ListCategoryServlet.URL)
public class ListCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String URL ="/auth/adm/list-category";
       

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetching all category

        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        //List<Category> categoryList = new ArrayList<>();
        List<Category> categoryList = categoryDao.getAll();
        
        for (Category category : categoryList) {
			System.out.println(category.getLibelee());
		}


        // Passing data in view
        req.setAttribute("categoryList", categoryList); 

        // Forwarding/Displaying listProduct JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listCategory.jsp");
        rd.forward(req, resp);



    }

	

}
