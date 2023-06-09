package com.example.trello.implementation;

import com.example.trello.entities.Folders;
import com.example.trello.repo_services.FolderRepoInterface;
import com.example.trello.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FolderIml implements FolderRepoInterface {

    @Autowired
    private FolderRepository repository;
    @Autowired
    private TaskCategoriesIml taskCategoriesIml;
    @Autowired
    private TaskIml taskIml;
    @Override
    public List<Folders> findAll() {
        return repository.findAll();
    }

    @Override
    public Folders getFolder(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addFolder(Folders folders) {
        repository.save(folders);
    }
    @Override
    public void deleteFolderById(Long id) {
        repository.deleteById(id);
    }
    public void updateFolder(Folders folders){
        repository.save(folders);
    }
}
