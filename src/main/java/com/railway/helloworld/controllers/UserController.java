package com.railway.helloworld.controllers;

import com.railway.helloworld.models.User;
import com.railway.helloworld.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserRepo users;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepo users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/account")
    public String account(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        model.addAttribute("user", user);
        return "users/account";
    }

    @GetMapping("/account/edit")
    public String showAccountEditForm(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/account/edit")
    public String accountEdit(@RequestParam String password, @RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        if(password != null && !password.isEmpty()) {
            String hash = this.passwordEncoder.encode(password);
            user.setPassword(hash);
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        users.save(user);
        return "redirect:/account";
    }

    @PostMapping("/account/delete")
    public String accountDelete(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        users.delete(user);
        return "redirect:/logout";
    }
}