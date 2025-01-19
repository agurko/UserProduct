package com.example.UserProduct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // Возвращает представление home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Возвращает представление login.html
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("message", "Welcome to the user page!");
        return "user"; // Возвращает представление user.html
    }
}

