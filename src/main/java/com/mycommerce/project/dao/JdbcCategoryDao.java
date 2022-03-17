package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JdbcCategoryDao implements CategoryDao {
    @Override
    public Long add(Category object) {

        EntityManager em = null;
        EntityTransaction transaction = null;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(object);
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
        return object.getId();
    }

    @Override
    public void update(Category object) {

    }

    @Override
    public Category findById(Long aLong) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public void remove(Category var1) {

    }

    @Override
    public void remove(Long aLong) {

    }
}
