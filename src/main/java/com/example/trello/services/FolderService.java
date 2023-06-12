package com.example.trello.services;

import com.example.trello.entities.Folders;
import com.example.trello.entities.TaskCategories;
import com.example.trello.implementation.FolderIml;
import com.example.trello.implementation.TaskCategoriesIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FolderService {
    @Autowired
    private FolderIml folderIml;


    @Autowired
    private TaskCategoriesIml taskCategoriesIml;


    public List<Folders> getAllFolder(){
        return folderIml.findAll();
    }
    public Folders getFolderById(Long id){
        return folderIml.getFolder(id);
    }
    public void addFolder(Folders folders){
         folderIml.addFolder(folders);
    }
    public void deleteFolder(Long folderId) {
        Folders folder = folderIml.getFolder(folderId);
        List<TaskCategories> taskCats = taskCategoriesIml.getAllCategories();
        List<TaskCategories> categoriesToRemove = new ArrayList<>();

        for (TaskCategories cat : folder.getCategories()) {
            for (TaskCategories taskCat : taskCats) {
                if (Objects.equals(cat.getId(), taskCat.getId())) {
                    categoriesToRemove.add(cat);
                    break;
                }
            }
        }
        folder.getCategories().removeAll(categoriesToRemove);
        folderIml.updateFolder(folder);
        folderIml.deleteFolderById(folderId);
    }
}
