package com.example.demo.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RequestMapping(path = "/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments(){
        return commentService.getComments();
    }

    @GetMapping(path = "{commentId}")
    public Optional<Comment> getCommentById(@PathVariable("commentId") long commentId){
        return commentService.getCommentById(commentId);
    }

    @PostMapping
    public void addComment(@RequestBody Comment c){
        commentService.addComment(c);
    }

    @DeleteMapping(path ="{commentId}")
    public void deleteComment(@PathVariable("commentId") long commentId){
        commentService.deleteComment(commentId);
    }
}
