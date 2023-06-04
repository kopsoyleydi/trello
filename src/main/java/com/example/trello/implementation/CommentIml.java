package com.example.trello.implementation;

import com.example.trello.entities.Comments;
import com.example.trello.repo_services.CommentRepoInterface;
import com.example.trello.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentIml implements CommentRepoInterface {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comments addComment(Comments comments) {
        return commentRepository.save(comments);
    }

    @Override
    public Comments getComment(Long id) {
        return commentRepository.getReferenceById(id);
    }

    @Override
    public Comments getCommentsByTaskId(Long id) {
        return commentRepository.findAllById(id);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
