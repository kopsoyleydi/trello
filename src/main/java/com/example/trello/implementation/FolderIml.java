package com.example.trello.implementation;

import com.example.trello.entities.Folders;
import com.example.trello.repo_services.FolderRepoInterface;
import com.example.trello.repository.FolderRepository;
import jakarta.persistence.PreRemove;
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
        return repository.findAllById(id);
    }

    @Override
    public void addFolder(Folders folders) {
        repository.save(folders);
    }

    @Override
    public void deleteFolder(Long id) {
        taskCategoriesIml.deleteById(id);
        taskIml.deleteAll();
        deleteFolder(id);
    }
}
