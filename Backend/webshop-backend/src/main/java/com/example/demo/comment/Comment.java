package com.example.demo.comment;

import javax.persistence.*;

@Entity
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;

    @Column(nullable = false)
    private long propertyId;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String text;

    private long parentCommentId;

    public Comment(long commentId, long propertyId, long userId,String text,long parentCommentId) {
        this.setCommentId(commentId);
        this.setPropertyId(propertyId);
        this.setUserId(userId);
        this.setText(text);
        this.setParentCommentId(parentCommentId);
    }

    public Comment(long propertyId, long userId,String text,long parentCommentId) {
        this.setPropertyId(propertyId);
        this.setUserId(userId);
        this.setText(text);
        this.setParentCommentId(parentCommentId);
    }

    public Comment() {
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", propertyId='" + propertyId + '\'' +
                ", userId='" + userId + '\'' +
                ", text='" + text + '\'' +
                ", parentCommentId=" + parentCommentId +
                '}';
    }
}
