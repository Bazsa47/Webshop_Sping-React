package com.example.demo.comment;

public class Comment {

    private int commentId;
    private String propertyId;
    private String userId;
    private String text;
    private int parentCommentId;

    public Comment() {
    }

    public Comment(String propertyId, String userId, String text, int parentCommentId) {
        this.propertyId = propertyId;
        this.userId = userId;
        this.text = text;
        this.parentCommentId = parentCommentId;
    }

    public Comment(int commentId, String propertyId, String userId, String text, int parentCommentId) {
        this.commentId = commentId;
        this.propertyId = propertyId;
        this.userId = userId;
        this.text = text;
        this.parentCommentId = parentCommentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(int parentCommentId) {
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
