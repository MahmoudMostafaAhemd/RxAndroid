package com.example.mahmoud.rxandroid.MainView.presenter;

import com.example.mahmoud.rxandroid.MainView.model.Post;

import java.util.List;

/**
 * Created by mahmoud on 6/28/16.
 */
public interface ListPresenter {
    void loadPosts(List<Post> posts);

    void onFail(String messaeg);

}
