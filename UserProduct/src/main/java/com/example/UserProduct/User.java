package com.example.UserProduct;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Product> products;

    private String password;


    public User() { }

    public User(Long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
// Getters and Setters
//    public Long getId() {   return id;    }
//    public void setId(Long id) {   this.id = id;    }
//    public String getName() {  return name;    }
//    public void setName(String name) {  this.name = name;    }
//    public Set<Product> getProducts() {   return products;    }
//    public void setProducts(Set<Product> products) {  this.products = products;    }
}
