package com.SmartCM.SmartCm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Home");
        model.addAttribute("YouTubeChannel", "Shani Chauan");
        model.addAttribute("GithubRepository", "https://github.com/");
        System.out.println("Home Page Controller");
        return "home";
    }

    // About Route Controller
    @RequestMapping("/about")
    public String about(Model model) {
        System.out.println("Page loading");
        return "about";

    }
    //services
    @RequestMapping("/services")
    public String services(Model model) {
        System.out.println("Services Page Controller");
        return "services";
    }
    //contact page
    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
