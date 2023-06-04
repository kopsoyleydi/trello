package com.example.trello.repo_services;

import com.example.trello.entities.Comments;

import java.util.List;

public interface CommentRepoInterface {
    Comments addComment(Comments comments);
    Comments getComment(Long id);
    Comments getCommentsByTaskId(Long id);
    void deleteComment(Long id);
}
