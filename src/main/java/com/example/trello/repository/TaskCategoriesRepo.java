package com.example.trello.repository;


import com.example.trello.entities.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskCategoriesRepo extends JpaRepository<TaskCategories,Long> {

    TaskCategories findAllById(Long id);
}
