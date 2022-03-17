
package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static ProductDao getProductDao() {
        return new JdbcProductDao();
    }
    public static CategoryDao getCategoryDao(){return new JdbcCategoryDao();}
    public static JdbcUtilisateurDao getUtilisateurDao(){return new JdbcUtilisateurDao();}
}
