package com.example.trello.controllers;


import com.example.trello.entities.Folders;
import com.example.trello.entities.StatusEntity;
import com.example.trello.entities.TaskCategories;
import com.example.trello.entities.Tasks;
import com.example.trello.repository.StatusRepo;
import com.example.trello.services.FolderService;
import com.example.trello.services.TaskCateService;
import com.example.trello.services.TaskService;
import jakarta.persistence.PreRemove;
import lombok.RequiredArgsConstructor;
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
    private final StatusRepo statusRepo;
    @GetMapping(value = "/")
    public String main(Model model){
        List<Folders> folders = folderService.getAllFolder();
        model.addAttribute("folders", folders);
        return "main-page";
    }
    @PostMapping(value = "/addFolder")
    public String addFolder(Folders folders){
        folderService.addFolder(folders);
        return "redirect:/";
    }
    @GetMapping(value = "detail-folder/{folder_id}")
    public String detail_folder(@PathVariable(name = "folder_id") Long id, Model model){
        Folders folder = folderService.getFolderById(id);
        List<Tasks> tasks = taskService.getTaskByFolderId(id);
        List<TaskCategories> taskCategoriesList = taskCateService.getListOfCategories();
        taskCategoriesList.removeAll(folder.getCategories());
        model.addAttribute("categories",taskCategoriesList);
        List<StatusEntity> statusEntityList = statusRepo.findAll();
        model.addAttribute("status",statusEntityList);
        model.addAttribute("folder",folder);
        model.addAttribute("tasks",tasks);
        return "folderDetails";
    }
    @PostMapping(value = "/addTask")
    public String addTask(Tasks tasks){
        Long folderId = tasks.getFolders().getId();
        taskService.addTask(tasks);
        return "redirect:/detail-folder/" + folderId;
    }
    @GetMapping(value = "/detail-task/{task_id}")
    public String detail_task(@PathVariable(name = "task_id") Long id,Model model){
        Tasks tasks = taskService.getTaskById(id);
        List<StatusEntity> statusEntity = statusRepo.findAll();
        model.addAttribute("status",statusEntity);
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

    @GetMapping(value = "categories")
    public String categories(Model model){
        List<TaskCategories> taskCategoriesList = taskCateService.getListOfCategories();
        model.addAttribute("categories",taskCategoriesList);
        return "categories";
    }
    @PostMapping(value = "/addCategories")
    public String addCategory(TaskCategories taskCategories){
        taskCateService.addCategory(taskCategories);
        return "redirect:/categories";
    }
    @PostMapping(value = "/saveTask")
    public String saveTask(Tasks tasks){
        taskService.updateTask(tasks);
        return "redirect:/detail-folder/" + tasks.getFolders().getId();
    }
    @PostMapping(value = "/delete_folder")
    public String deleteFolder(@RequestParam(name = "folder_id") Long folderId){
        folderService.deleteById(folderId);
        return "redirect:/";
    }
}
