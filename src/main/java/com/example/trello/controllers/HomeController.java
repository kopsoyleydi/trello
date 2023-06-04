package com.example.trello.controllers;


import com.example.trello.entities.Folders;
import com.example.trello.entities.TaskCategories;
import com.example.trello.services.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FolderService folderService;
    @GetMapping
    public String main(Model model){
        List<Folders> folders = folderService.getAllFolder();
        model.addAttribute("folders", folders);
        return "main-page";
    }
    @GetMapping
    public String folder_detail(Model model, @RequestParam(name = "id") Long id){
        Folders folder = folderService.getFolderById(id);
        model.addAttribute("folder",folder);
        return "folderDetails";
    }
    public String addCategory(Model model, TaskCategories taskCategories){
        return "redirect:/";
    }
}
