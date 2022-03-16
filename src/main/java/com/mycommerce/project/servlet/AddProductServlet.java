package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/auth/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = DaoFactory.getCategoryDao().getAll();
        System.out.println("categoryList size : "+categoryList.size());
        req.setAttribute("categoryList",categoryList);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("pName");
        String productContent = req.getParameter("pContent");
        String productPriceStr = req.getParameter("pPrice");
        long productCategoryId = Long.parseLong(req.getParameter("pCategory"));
        Category category = DaoFactory.getCategoryDao().findById(productCategoryId);
        try {
            float productPrice = Float.parseFloat(productPriceStr);
            Product newProduct = new Product(productName, productContent, productPrice,category);
            System.out.println("test");
            ProductDao productDao = DaoFactory.getProductDao();
            Long id = productDao.add(newProduct);
            resp.sendRedirect(ShowProductServlet.URL + "?id=" + id);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
