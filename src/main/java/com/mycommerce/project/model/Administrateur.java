package com.mycommerce.project.model;

import jakarta.persistence.Entity;


@Entity
public class Administrateur extends Personne{
    public static final  boolean isAdmin=true;
}
