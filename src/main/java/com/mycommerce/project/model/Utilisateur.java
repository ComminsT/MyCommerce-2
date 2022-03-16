package com.mycommerce.project.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur extends Personne {
    public static final  boolean isAdmin=false;

    @OneToOne
    private Panier panier;

}
