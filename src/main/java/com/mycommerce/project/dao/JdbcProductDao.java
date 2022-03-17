package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    public JdbcProductDao() {
    }

    @Override
    public Long add(Product p) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(p);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return p.getId();
    }

    @Override
    public void update(Product p) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(p);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }


    }

    @Override
    public Product findById(Long id) {
        EntityManager em = null;
        Product product = null;

        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Product where id = :id");
            query.setParameter("id", id);
            product = (Product) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }


        return product;
    }

    @Override
    public List<Product> getAll() {
        EntityManager em = null;
        List<Product> productList = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Product ");
            productList = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productList;
    }

    @Override
    public void remove(Product p) {

        EntityManager em = null;
        EntityTransaction transaction = null;
        Product product ;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            product = em.find(Product.class,p.getId());
            em.remove(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            System.out.println("Erreur : "+e.getMessage());
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void remove(Long id) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Product product = null;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            product = em.find(Product.class,id);
               em.remove(product);
            transaction.commit();

        }catch (Exception e){
            System.out.println("Erreur : "+e.getMessage());
            if(transaction !=null){
                transaction.rollback();
            }

        }finally {
            if(em != null){
                em.close();
            }
        }

    }
}
