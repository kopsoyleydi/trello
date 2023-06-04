package com.example.trello.repository;

import com.example.trello.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<StatusEntity,Long> {
}
