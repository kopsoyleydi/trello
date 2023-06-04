package com.example.trello.controllers;


import com.example.trello.entities.Folders;
import com.example.trello.entities.TaskCategories;
import com.example.trello.entities.Tasks;
import com.example.trello.implementation.TaskCategoriesIml;
import com.example.trello.implementation.TaskIml;
import com.example.trello.services.FolderService;
import com.example.trello.services.TaskCateService;
import com.example.trello.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final FolderService folderService;
    private final TaskService taskService;
    private final TaskCateService taskCateService;
    @GetMapping(value = "/")
    public String main(Model model){
        List<Folders> folders = folderService.getAllFolder();
        model.addAttribute("folders", folders);
        return "main-page";
    }
    @GetMapping(value = "detail-folder/{folder_id}")
    public String detail_folder(@PathVariable(name = "folder_id") Long id, Model model){
        Folders folder = folderService.getFolderById(id);
        List<Tasks> tasks = taskService.getTaskByFolderId(id);
        List<TaskCategories> taskCategoriesList = taskCateService.getListOfCategories();
        taskCategoriesList.removeAll(folder.getCategories());
        model.addAttribute("categories",taskCategoriesList);
        model.addAttribute("folder",folder);
        model.addAttribute("tasks",tasks);
        return "folderDetails";
    }
    @GetMapping(value = "detail-task/{task_id}")
    public String detail_task(@PathVariable(name = "task_id") Long id,Model model){
        Tasks tasks = taskService.getTaskById(id);
        model.addAttribute("task",tasks);
        return "TaskDetail";
    }

    @PostMapping(value = "/assign_category")
    public String assignCat(@RequestParam(name = "folder_id") Long folderId,@RequestParam(name = "cat_id") Long catId){
        taskCateService.assign_category(folderId,catId);
        return "redirect:/detail-folder/" + folderId;
    }

    @PostMapping(value = "unassign_category")
    public String unassignCat(@RequestParam(name = "folder_id") Long folderId,@RequestParam(name = "cat_id") Long catId){
        taskCateService.unassign_category(folderId,catId);
        return "redirect:/detail-folder/" + folderId;
    }
}
