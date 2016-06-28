package com.example.mahmoud.rxandroid;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.MainView.presenter.ListPresenter;

import java.util.List;

/**
 * Created by mahmoud on 28-Jun-16.
 */
class DummyView implements ListPresenter {
    public boolean isloadPostCalled = false;
    public boolean isFailCalled = false;

    @Override
    public void loadPosts(List<Post> posts) {
        isloadPostCalled = true;
    }

    @Override
    public void onFail(String messaeg) {
        isFailCalled = true;
    }
}
