package com.example.trello.implementation;

import com.example.trello.entities.Tasks;
import com.example.trello.repo_services.TasksRepoInterface;
import com.example.trello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskIml implements TasksRepoInterface {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Tasks addTask(Tasks tasks) {
        return taskRepository.save(tasks);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Tasks> getTaskByFolderId(Long id) {
        return taskRepository.getAllByFoldersId(id);
    }
    public Tasks getTaskById(Long id){
        return taskRepository.findAllById(id);
    }
}
