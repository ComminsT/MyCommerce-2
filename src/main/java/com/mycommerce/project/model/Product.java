package com.mycommerce.project.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "product")
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private float price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "panier_product",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Panier> paniers = new ArrayList<>();

    public Product() {
    }

    Product(Long id, String name, String content, float price,Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
        this.category=category;
    }

    public Product(String name, String content, float price, Category category) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.category=category;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
