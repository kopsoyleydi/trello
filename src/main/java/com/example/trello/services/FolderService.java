package com.example.trello.services;

import com.example.trello.entities.Folders;
import com.example.trello.entities.TaskCategories;
import com.example.trello.implementation.FolderIml;
import com.example.trello.implementation.TaskCategoriesIml;
import com.example.trello.repository.FolderRepository;
import com.example.trello.repository.TaskCategoriesRepo;
import jakarta.persistence.PreRemove;
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
    public void deleteFolder(Long folderId){
        Folders folders = folderIml.getFolder(folderId);
        List<TaskCategories> taskCategories = taskCategoriesIml.getAllCategories();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<taskCategories.size();i++){
            if(Objects.equals(folders.getCategories().get(i).getId(), taskCategories.get(i).getId())){
                arr.add(Math.toIntExact(taskCategories.get(i).getId()));
            }
        }
        for(int i =0;i< arr.size();i++){
            int arrId = arr.get(i);
            folders.getCategories().remove(arrId);
        }
        folderIml.updateFolder(folders);
        folderIml.deleteFolderById(folderId);
    }
}
