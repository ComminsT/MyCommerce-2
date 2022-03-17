package com.mycommerce.project.dao.base;

import com.mycommerce.project.model.Utilisateur;

public interface UtilisateurDAO extends GenericDao<Utilisateur,Long>{
    Utilisateur connect(String username,String mdp);
}
