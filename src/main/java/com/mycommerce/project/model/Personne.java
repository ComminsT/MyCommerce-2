package com.mycommerce.project.model;

import jakarta.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


}
