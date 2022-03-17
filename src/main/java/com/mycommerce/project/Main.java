package com.mycommerce.project;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.JdbcProductDao;
import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
        EntityManager em = emf.createEntityManager();
        DaoFactory.getUtilisateurDao().add(new Utilisateur("a","b"));

        em.close();
        emf.close();



    }
}
