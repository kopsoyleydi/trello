package com.example.trello.repo_services;

import com.example.trello.entities.Tasks;

import java.util.List;

public interface TasksRepoInterface {

    Tasks addTask(Tasks tasks);
    List<Tasks> getAllTasks();
    List<Tasks> getTaskByFolderId(Long id);
    Tasks getTaskById(Long id);
}
