package com.example.UserProduct;

import com.example.UserProduct.Product;
import com.example.UserProduct.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products"; // Возвращаем имя шаблона
    }

    @PostMapping
    public String createProduct(@RequestParam String name) {
        Product product = new Product();
        product.setName(name);
        productRepository.save(product);
        return "redirect:/products"; // Перенаправление после создания
    }

    @PostMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products"; // Перенаправление после удаления
    }
}

