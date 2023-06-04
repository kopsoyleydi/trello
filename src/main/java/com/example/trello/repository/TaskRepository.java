package com.example.trello.repository;

import com.example.trello.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks,Long> {
    List<Tasks> getAllByFoldersId(Long id);

    Tasks findAllById(Long id);
}
