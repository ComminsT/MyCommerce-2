package com.mycommerce.project;

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
        Category category = new Category("cat1");
        Product p1 = new Product("product1","content1",5F,category);
        JPADaoManager.getInstance().getCategoryDao().add(category);
        long newId=JPADaoManager.getInstance().getProductDao().add(p1);

        em.close();
        emf.close();

    }
}
