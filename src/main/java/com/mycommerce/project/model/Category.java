package com.mycommerce.project.model;

import java.util.ArrayList;

public class Category {
    private long id;
    private String libelee;
    private ArrayList<Product> products;


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
