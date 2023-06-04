package com.example.trello.implementation;

import com.example.trello.entities.TaskCategories;
import com.example.trello.repo_services.TaskCategoriesRepoService;
import com.example.trello.repo_services.TasksRepoInterface;
import com.example.trello.repository.TaskCategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoriesIml implements TaskCategoriesRepoService {

    @Autowired
    private TaskCategoriesRepo taskCategoriesRepo;
    @Override
    public TaskCategories addTaskCategory(TaskCategories taskCategories) {
        return taskCategoriesRepo.save(taskCategories);
    }

    @Override
    public void updateTaskCategories(TaskCategories taskCategories) {
        taskCategoriesRepo.save(taskCategories);
    }

    @Override
    public TaskCategories getCategoryById(Long id) {
        return taskCategoriesRepo.findAllById(id);
    }
    public List<TaskCategories> getAllCategories(){
        return taskCategoriesRepo.findAll();
    }

}
