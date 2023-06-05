package com.example.trello.services;

import com.example.trello.entities.Folders;
import com.example.trello.implementation.FolderIml;
import jakarta.persistence.PreRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {
    @Autowired
    private FolderIml folderIml;

    public List<Folders> getAllFolder(){
        return folderIml.findAll();
    }
    public Folders getFolderById(Long id){
        return folderIml.getFolder(id);
    }
    public void addFolder(Folders folders){
         folderIml.addFolder(folders);
    }
    public void deleteById(Long id){
        folderIml.deleteFolderById(id);
    }
}
