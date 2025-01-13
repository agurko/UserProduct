package com.example.UserProduct;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Product> products;

    // Getters and Setters
    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public Set<Product> getProducts() {        return products;    }
    public void setProducts(Set<Product> products) {  this.products = products;    }
}
