package com.example.trello.repo_services;

import com.example.trello.entities.Comments;

import java.util.List;

public interface CommentRepoInterface {
    void addComment(Comments comments);
    Comments getComment(Long id);
    List<Comments> getCommentsByTaskId(Long id);
    void deleteComment(Long id);
}
