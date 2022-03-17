package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(ListProductServlet.URL)
public class ListProductServlet extends HttpServlet {

    public final static String URL = "/list-product";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetching all products
        List<Product> productList = JPADaoManager.getInstance().getProductDao().getAll();

        // Passing data in view
        req.setAttribute("productList", productList);

        // Forwarding/Displaying listProduct JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req, resp);
    }
}
