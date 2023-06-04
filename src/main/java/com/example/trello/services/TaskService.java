package com.example.trello.services;


import com.example.trello.entities.Tasks;
import com.example.trello.implementation.TaskIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskIml taskIml;

    public List<Tasks> getTaskByFolderId(Long id){
        return taskIml.getTaskByFolderId(id);
    }
    public Tasks getTaskById(Long id){
        return taskIml.getTaskById(id);
    }
}
