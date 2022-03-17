package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.dao.base.PanierDao;
import com.mycommerce.project.model.Panier;
import com.mycommerce.project.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class JdbcPanierDao implements PanierDao {
    @Override
    public Long add(Panier p) {
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
    public void update(Panier p) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Product product = null;
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
    public Panier findById(Long id) {
        EntityManager em = null;
        Panier panier = null;

        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Panier where id = :id");
            query.setParameter("id", id);
            panier = (Panier) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return panier;

    }

    @Override
    public List<Panier> getAll() {
        EntityManager em = null;
        List<Panier> panierList = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Panier ");
            panierList = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return panierList;
    }

    @Override
    public void remove(Panier p) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Panier panier;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            panier = em.find(Panier.class,p.getId());
            em.remove(panier);
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
    public void remove(Long id) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Panier panier = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            panier = em.find(Panier.class,id);
            em.remove(panier);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

}
