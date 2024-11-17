package com.SmartCM.SmartCm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public  String home(Model model) {
        model.addAttribute("name", "Home");
        model.addAttribute("YouTubeChannel", "Shani Chauan");
        model.addAttribute("GithubRepository", "https://github.com/");
        System.out.println("Home Page Controller");
        return "home";
    }


}
