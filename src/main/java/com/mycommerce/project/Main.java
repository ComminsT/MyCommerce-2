package com.mycommerce.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
        EntityManager em = emf.createEntityManager();
        Category category = new Category("cat1");
        Category category2 = new Category(5,"cat2");
        Category category3 = new Category("cat3");
        Product p1 = new Product("product1","content1",5F,category);


        Product p2 = new Product("product2","content2",5F,category);
        JPADaoManager.getInstance().getCategoryDao().add(category);
        JPADaoManager.getInstance().getCategoryDao().add(category2);
        JPADaoManager.getInstance().getCategoryDao().add(category3);
        long newId=JPADaoManager.getInstance().getProductDao().add(p1);
        
        category.setLibelee("cat111");
        JPADaoManager.getInstance().getCategoryDao().update(category);

        System.out.println( JPADaoManager.getInstance().getCategoryDao().findById(category2.getId()));
        
        List<Category> cats = new ArrayList<Category>();
        cats = JPADaoManager.getInstance().getCategoryDao().getAll();
        
        for (Category category4 : cats) {
			System.out.println(category4.getLibelee());
		}
       

        JPADaoManager.getInstance().getCategoryDao().remove(category2);
        //JPADaoManager.getInstance().getCategoryDao().remove(category3.getId());
        
        
        em.close();
        emf.close();

    }
}
