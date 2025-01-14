package com.example.UserProduct;

import com.example.UserProduct.Product;
import com.example.UserProduct.User;
import com.example.UserProduct.ProductRepository;
import com.example.UserProduct.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Создание пользователя
        User user = new User();
        user.setName("John Doe");

        // Создание продуктов
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setUser (user);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setUser (user);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setUser (user);

        // Установка продуктов для пользователя
        user.setProducts(new HashSet<>());
        user.getProducts().add(product1);
        user.getProducts().add(product2);
        user.getProducts().add(product3);

        // Сохранение пользователя и продуктов в базе данных
        userRepository.save(user); // Это также сохранит продукты благодаря каскадированию
    }
}

