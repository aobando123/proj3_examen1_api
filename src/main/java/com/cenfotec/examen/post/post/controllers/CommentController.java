package com.cenfotec.examen.post.post.controllers;

import com.cenfotec.examen.post.post.domain.Comment;
import com.cenfotec.examen.post.post.services.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping()
    public Comment PostComment(@RequestBody Comment comment) {
        return this.commentService.postComment(comment);
    }

    @PutMapping()
    public Comment updateComment(@RequestBody Comment comment) {
        return this.commentService.updateComment(comment);
    }

}
