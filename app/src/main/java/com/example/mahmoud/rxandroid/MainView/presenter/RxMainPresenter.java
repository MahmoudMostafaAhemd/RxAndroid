package com.example.mahmoud.rxandroid.MainView.presenter;


import android.util.Log;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.servecies.ForumService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mahmoud on 6/28/16.
 */
public class RxMainPresenter implements MainInterface {

    private final ListPresenter listener;
    private final ForumService mForum;

    public RxMainPresenter(ListPresenter view) {
        listener = view;
        mForum = new ForumService();
    }


    public void loadPosts() {
        mForum.getApi().getPosts().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (listener != null) {
                            listener.onFail(e.getMessage());
                        }

                    }

                    @Override
                    public void onNext(List<Post> posts) {

                        if (posts == null || posts.size() == 0)
                            listener.onFail("");
                        else if (listener != null) {
                            listener.loadPosts(posts);
                        }

                    }
                });
    }
}
