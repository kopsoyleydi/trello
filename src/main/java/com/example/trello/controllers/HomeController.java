package com.example.trello.controllers;


import com.example.trello.entities.TaskCategories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    @GetMapping
    public String main(){
        return "main-page";
    }

    public String addCategory(Model model, TaskCategories taskCategories){
        return "redirect:/";
    }
}
