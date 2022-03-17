package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    public JdbcProductDao() {
    }

    @Override
    public Long add(Product var1) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(var1);
            transaction.commit();

        }catch(Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            System.out.println("Erreur : "+e.getMessage());
        }finally {
            if(em != null){
                em.close();
            }
        }
        return var1.getId();
    }

    @Override
    public void update(Product var1) {
        //TODO
    }

    @Override
    public Product findById(Long var1) {
        //TODO
        return null;
    }

    @Override
    public List<Product> getAll() {
        //TODO
        EntityManager em = null;
        List<Product> productList = null;
        try{
            em= JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Product ");
            productList = query.getResultList();

        }catch(Exception e){
            System.out.println("Erreur: "+e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return productList;
    }

    @Override
    public void remove(Product var1) {
        //TODO
    }

    @Override
    public void remove(Long var1) {
        //TODO
    }
}
