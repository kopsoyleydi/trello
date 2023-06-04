package com.example.trello.repo_services;

import com.example.trello.entities.Tasks;

import java.util.List;

public interface TasksRepoInterface {

    void addTask(Tasks tasks);
    List<Tasks> getAllTasks();
}
