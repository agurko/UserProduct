package com.example.UserProduct;

import com.example.UserProduct.User;
import com.example.UserProduct.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users"; // Возвращаем имя шаблона
    }

    @PostMapping
    public String createUser (@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return "redirect:/users"; // Перенаправление после создания
    }

    @PostMapping("/{id}")
    public String deleteUser (@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/users"; // Перенаправление после удаления
    }
}

