package com.mycommerce.project.dao;



import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
    	
    	 EntityManager em = null;
         EntityTransaction transaction = null;
         try{
             em = JPADaoManager.getInstance().getEmf().createEntityManager();
             transaction = em.getTransaction();
             transaction.begin();
             em.merge(object);
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
     }
    	
    	

   

    @Override
    public Category findById(Long aLong) {
        
    	EntityManager em = null;
		Category cat = null;
		
		try {
			em = JPADaoManager.getInstance().getEmf().createEntityManager();
			//em.getTransaction().begin();
			Query query = em.createQuery("from Category where id = :id");
			query.setParameter("id", aLong);

			cat = (Category) query.getSingleResult();
		}catch(Exception e) {
			System.out.println("erreur in FINDONE" + e.getMessage());
		}finally {
			if(em != null) {
				em.close();
			}
		}
		return cat;
    	
    }

    @Override
    public List<Category> getAll() {
    	
    	EntityManager em = null;
		List<Category> cats = null;
		
		try {
			em = JPADaoManager.getInstance().getEmf().createEntityManager();
			//em.getTransaction().begin();
			Query query = em.createQuery("SELECT c from Category c");
			cats = query.getResultList();		

		}catch(Exception e) {
			System.out.println("erreur in FINDONE" + e.getMessage());
		}finally {
			if(em != null) {
				em.close();
			}
		}
		return cats;
    	
    }

    @Override
    public void remove(Category var1) {
    	EntityManager em = null;
    	EntityTransaction transaction = null;
    	try{
    		em = JPADaoManager.getInstance().getEmf().createEntityManager();
    		transaction = em.getTransaction();
    		transaction.begin();
    		
    		Category c = em.find(Category.class,1L);
    		em.remove(var1);
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
    public void remove(Long aLong) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Category cat = null;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            cat = findById(aLong);
            em.remove(cat);
            transaction.commit();

        }catch (Exception e){
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
