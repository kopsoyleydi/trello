package com.example.trello.repo_services;

import com.example.trello.entities.TaskCategories;
import com.example.trello.entities.Tasks;

public interface TaskCategoriesRepoService {
    void addTaskCategory(TaskCategories taskCategories);

    void updateTaskCategories(TaskCategories taskCategories);
}
