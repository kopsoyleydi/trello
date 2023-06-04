package com.example.trello.repository;

import com.example.trello.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {
    Comments findAllById(Long id);
}
