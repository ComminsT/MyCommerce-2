package com.mycommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Utilisateur extends Personne {
    public static final  boolean isAdmin=false;

    @OneToOne
    private Panier panier;


    public Utilisateur(String userName, String mdp) {
        super(userName, mdp);
    }

    public Utilisateur() {
        super();
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
