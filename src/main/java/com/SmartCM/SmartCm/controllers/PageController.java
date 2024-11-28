package com.SmartCM.SmartCm.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SmartCM.SmartCm.entities.User;
import com.SmartCM.SmartCm.forms.UserForm;
import com.SmartCM.SmartCm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    // Home Page
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Home");
        model.addAttribute("YouTubeChannel", "Shani Chauhan");
        model.addAttribute("GithubRepository", "https://github.com/");
        System.out.println("Home Page Controller");
        return "home";
    }

    // About Page
    @RequestMapping("/about")
    public String about() {
        System.out.println("About Page Controller");
        return "about";
    }

    // Services Page
    @RequestMapping("/services")
    public String services() {
        System.out.println("Services Page Controller");
        return "services";
    }

    // Contact Page
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    // Login Page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Register Page
    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm(); // For form data binding
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // Processing Registration
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {

        System.out.println("Processing Registration");
        //fetch from data 
        //validate form data 
        //save to dataBASE 
        System.out.println(userForm);




//userForm ---> User 
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("https://shani-chauhan.netlify.app/assets/1.png")
        .build();
       User savedUser=userService.saveUser(user);
       System.out.println("user saved");  // you can use this user id for further operations.

        
        // Redirect to the login page after successful registration
        return "redirect:/register";
    }
}