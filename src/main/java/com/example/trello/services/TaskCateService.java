package com.example.trello.services;


import com.example.trello.entities.Folders;
import com.example.trello.entities.TaskCategories;
import com.example.trello.entities.Tasks;
import com.example.trello.implementation.FolderIml;
import com.example.trello.implementation.TaskCategoriesIml;
import com.example.trello.implementation.TaskIml;
import com.example.trello.repository.FolderRepository;
import com.example.trello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskCateService {
    @Autowired
    private TaskCategoriesIml taskCategoriesIml;
    @Autowired
    private FolderRepository folderRepository;

    public void assign_category(Long folderId, Long categoryId){
        Folders folders = folderRepository.findAllById(folderId);
        TaskCategories taskCategories = taskCategoriesIml.getCategoryById(categoryId);
        if(folders.getCategories() != null && folders.getCategories().size() > 0){
            if(!folders.getCategories().contains(taskCategories)){
                folders.getCategories().add(taskCategories);
            }
        }
        else{
            List<TaskCategories> taskCategoriesList = new ArrayList<>();
            taskCategoriesList.add(taskCategories);
            folders.setCategories(taskCategoriesList);
        }
        folderRepository.save(folders);
    }
    public void unassign_category(Long folderId, Long categoryId){
        Folders folders = folderRepository.findAllById(folderId);
        TaskCategories taskCategories = taskCategoriesIml.getCategoryById(categoryId);
        if(folders.getCategories() != null && folders.getCategories().size() > 0){
            folders.getCategories().remove(taskCategories);
        }
        folderRepository.save(folders);
    }
    public List<TaskCategories> getListOfCategories(){
        return taskCategoriesIml.getAllCategories();
    }
    public void addCategory(TaskCategories taskCategories){
        taskCategoriesIml.addTaskCategory(taskCategories);
    }
}
