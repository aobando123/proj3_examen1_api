package com.cenfotec.examen.post.post.services;

import com.cenfotec.examen.post.post.domain.Comment;
import com.cenfotec.examen.post.post.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment postComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
