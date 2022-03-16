package com.mycommerce.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelee;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();


    public Category() {
    }

    public Category(String libelee) {
        this.libelee = libelee;
    }
    
    public Category(long id, String libelee) {
    	this.id = id;
    	this.libelee = libelee;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public String getLibelee() {
        return libelee;
    }

    public void setLibelee(String libelee) {
        this.libelee = libelee;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", libelee='" + libelee + '\'' +
                '}';
    }
}
