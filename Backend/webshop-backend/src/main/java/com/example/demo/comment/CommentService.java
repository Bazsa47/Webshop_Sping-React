package com.example.demo.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public void addComment(Comment c) {
        commentRepository.save(c);
    }

    public void deleteComment(long commentId) {
        if (!commentRepository.findById(commentId).isPresent()) throw new IllegalStateException("Comment id does not exist!");
        commentRepository.deleteById(commentId);
    }
}
