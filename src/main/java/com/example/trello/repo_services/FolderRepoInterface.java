package com.example.trello.repo_services;

import com.example.trello.entities.Folders;

import java.util.List;

public interface FolderRepoInterface {
    List<Folders> findAll();
    Folders getFolder(Long id);
    void addFolder(Folders folders);

    void deleteFolderById(Long id);
}
