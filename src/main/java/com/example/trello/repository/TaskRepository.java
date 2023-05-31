package com.example.trello.repository;

import com.example.trello.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks,Long> {
}
