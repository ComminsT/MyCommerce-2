package com.mycommerce.project.servlet;

import java.io.IOException;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.model.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public final static String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        Utilisateur utilisateur = DaoFactory.getUtilisateurDao().connect(username,pwd);
        if(utilisateur !=null){
            resp.sendRedirect(ListProductServlet.URL);
        }else{
            System.out.println("Erreur");
        }

    }
}
