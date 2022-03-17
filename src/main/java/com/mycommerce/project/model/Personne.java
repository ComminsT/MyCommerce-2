package com.mycommerce.project.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String mdp;


    public Personne() {
        
    }

    public Personne(String userName, String mdp) {
    }
}
