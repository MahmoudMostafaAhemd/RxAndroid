package com.example.mahmoud.rxandroid.commentsView.model;

/**
 * Created by mahmoud on 6/28/16.
 */
public class Comment {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;

    @Override
    public String toString() {
        return "Comment{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
