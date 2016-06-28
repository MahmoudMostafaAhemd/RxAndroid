package com.example.mahmoud.rxandroid.commentsView.presenter;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.commentsView.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahmoud on 28-Jun-16.
 */
public class CommentsUnitTest implements RxCommentsPresenter {

    List<Comment> comments;
    DetailPresenter detailPresenter;
    Post post;

    public CommentsUnitTest(DetailPresenter detailPresenter) {
        this.detailPresenter = detailPresenter;
        comments = new ArrayList<>();
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        comments.add(new Comment());
        post = new Post();
        post.body = "body";
        post.title = "title";
    }

    public void setListOfPost(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public void loadPost() {
        if (detailPresenter != null)
            detailPresenter.loadPost(post);
    }

    @Override
    public void loadComments() {
        if (comments == null || comments.size() == 0)
            detailPresenter.onFail("");
        else if (detailPresenter != null)
            detailPresenter.loadComments(comments);
    }
}
