package com.example.mahmoud.rxandroid.commentsView.presenter;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.MainView.presenter.ListPresenter;
import com.example.mahmoud.rxandroid.commentsView.model.Comment;

import java.util.List;

/**
 * Created by mahmoud on 6/28/16.
 */
public interface DetailPresenter {

    void loadPost(Post posts);

    void loadComments(List<Comment> comments);

    void onFail(String error);
}
