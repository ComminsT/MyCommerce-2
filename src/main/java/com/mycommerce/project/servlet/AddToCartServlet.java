package com.mycommerce.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Panier;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.model.Utilisateur;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		//Mock
		Utilisateur u = new Utilisateur();
		httpSession.setAttribute("user", u);
		//
        Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("user");
		Panier panier = utilisateur.getPanier();
		
		ProductDao productDao = DaoFactory.getProductDao();
		Product p = productDao.findById(Long.parseLong(request.getParameter("productId")));
		
		//System.out.println("Panier avant :"+panier.getProductList().size());
		panier.getProductList().add(p);		
		System.out.println("Panier aprés :"+panier.getProductList().size());
		System.out.println("size : "+((Utilisateur)httpSession.getAttribute("user")).getPanier().getProductList().size());
	}

}
