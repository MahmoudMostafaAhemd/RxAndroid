package com.example.mahmoud.rxandroid.MainView.presenter;

import com.example.mahmoud.rxandroid.MainView.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahmoud on 28-Jun-16.
 */
public class AsyncMainPresenter implements MainInterface {
    private List<Post> listOfPost;
    private final ListPresenter listener;


    public AsyncMainPresenter(ListPresenter view) {
        listener = view;

        listOfPost = new ArrayList<>();
        listOfPost.add(new Post());
        listOfPost.add(new Post());
        listOfPost.add(new Post());
        listOfPost.add(new Post());
        listOfPost.add(new Post());
        listOfPost.add(new Post());
    }

    public void setListOfPost(List<Post> posts) {
        listOfPost = posts;
    }

    @Override
    public void loadPosts() {

        if (listOfPost == null || listOfPost.size() == 0) {
            listener.onFail("");
        } else if (listener != null) {
            listener.loadPosts(listOfPost);
        }

    }
}
