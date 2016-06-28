package com.example.mahmoud.rxandroid;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.commentsView.model.Comment;
import com.example.mahmoud.rxandroid.commentsView.presenter.DetailPresenter;

import java.util.List;

/**
 * Created by mahmoud on 28-Jun-16.
 */
class DummyCommentsView implements DetailPresenter {
    public boolean isLoadPostCalled = false;
    public boolean isFailCalled = false;
    public boolean isLoadCommentsCalled = false;
    public boolean isLoadCommentsFailed = false;

    @Override
    public void loadPost(Post posts) {
        isLoadPostCalled = true;
    }

    @Override
    public void loadComments(List<Comment> comments) {
        isLoadCommentsCalled = true;
    }

    @Override
    public void onFail(String error) {
        isLoadCommentsFailed = true;
        isFailCalled = true;
    }
}
