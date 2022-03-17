package com.mycommerce.project.dao.base;

import com.mycommerce.project.dao.JdbcCategoryDao;
import com.mycommerce.project.dao.JdbcPanierDao;
import com.mycommerce.project.dao.JdbcProductDao;
import com.mycommerce.project.dao.MemoryCatDao;
import lombok.Getter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Getter
public class JPADaoManager {
    private static JPADaoManager instance=null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
    private ProductDao productDao = new  JdbcProductDao ();
    private CategoryDao categoryDao = new JdbcCategoryDao();
    private PanierDao panierDao = new JdbcPanierDao();

    private JPADaoManager (){};
    public static JPADaoManager getInstance(){
        if(instance == null){
            instance=new JPADaoManager();
        }
        return instance;
    }
    public static void stop(){
        instance.emf.close();
    }
}
