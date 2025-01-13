package com.example.UserProduct;

import com.example.UserProduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}

