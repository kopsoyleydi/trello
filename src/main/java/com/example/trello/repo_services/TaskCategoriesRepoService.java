package com.example.trello.repo_services;

import com.example.trello.entities.Tasks;

public interface TaskCategoriesRepoService {
    Tasks addTask(Tasks tasks);

    void getTask(Long id);

    void updateTask(Tasks tasks);
}
