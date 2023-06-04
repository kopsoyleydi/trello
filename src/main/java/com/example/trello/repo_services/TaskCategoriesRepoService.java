package com.example.trello.repo_services;

import com.example.trello.entities.TaskCategories;
import com.example.trello.entities.Tasks;

public interface TaskCategoriesRepoService {
    TaskCategories addTaskCategory(TaskCategories taskCategories);

    void updateTaskCategories(TaskCategories taskCategories);
    TaskCategories getCategoryById(Long id);
}
