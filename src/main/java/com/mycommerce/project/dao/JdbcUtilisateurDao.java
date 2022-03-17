package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.JPADaoManager;
import com.mycommerce.project.dao.base.UtilisateurDAO;
import com.mycommerce.project.model.Panier;
import com.mycommerce.project.model.Utilisateur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class JdbcUtilisateurDao implements UtilisateurDAO {

    @Override
    public Long add(Utilisateur u) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(u);
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
        return u.getId();
    }

    @Override
    public void update(Utilisateur u) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(u);
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
    public Utilisateur findById(Long id) {
        EntityManager em = null;
        Utilisateur utilisateur = null;

        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Utilisateur where id = :id");
            query.setParameter("id", id);
            utilisateur = (Utilisateur) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }


        return utilisateur;
    }

    @Override
    public List<Utilisateur> getAll() {
        EntityManager em = null;
        List<Utilisateur> utilisateurList = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Utilisateur ");
            utilisateurList = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return utilisateurList;
    }

    @Override
    public void remove(Utilisateur u) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(u);
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
        Utilisateur utilisateur = null;
        try{
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            utilisateur = em.find(Utilisateur.class,id);
            em.remove(utilisateur);
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

    @Override
    public Utilisateur connect(String username, String mdp) {
        EntityManager em = null;
        Utilisateur utilisateur = null;
        try {
            em = JPADaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Utilisateur where userName = :username AND mdp= :mdp");
            query.setParameter("username", username);
            query.setParameter("mdp", mdp);
            utilisateur = (Utilisateur) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return utilisateur;
    }
}
