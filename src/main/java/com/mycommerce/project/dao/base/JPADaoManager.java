package com.mycommerce.project.dao.base;

import com.mycommerce.project.dao.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPADaoManager {
    private static JPADaoManager instance=null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
    private ProductDao productDao = new  JdbcProductDao ();
    private CategoryDao categoryDao = new JdbcCategoryDao();
    private PanierDao panierDao = new JdbcPanierDao();
    private UtilisateurDAO utilisateurDAO = new JdbcUtilisateurDao();

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
	public EntityManagerFactory getEmf() {
		return this.emf;
	}
	public ProductDao getProductDao() {
		
		return this.productDao;
	}
	public CategoryDao getCategoryDao() {
		
		return this.categoryDao;
	}
}
