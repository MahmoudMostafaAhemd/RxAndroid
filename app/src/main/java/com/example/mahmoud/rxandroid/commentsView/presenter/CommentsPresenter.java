package com.example.mahmoud.rxandroid.commentsView.presenter;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.commentsView.model.Comment;
import com.example.mahmoud.rxandroid.servecies.ForumService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mahmoud on 6/28/16.
 */
public class CommentsPresenter implements RxCommentsPresenter {

    private final ForumService mForum;
    private final DetailPresenter detailPresenter;
    private int id;

    public CommentsPresenter(DetailPresenter detailPresenter, int id) {
        mForum = new ForumService();
        this.detailPresenter = detailPresenter;
        this.id = id;
    }

    @Override
    public void loadPost() {
        mForum.getApi().getPost(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (detailPresenter != null)
                            detailPresenter.onFail(e.toString());
                    }

                    @Override
                    public void onNext(Post post) {
                        if (detailPresenter != null)
                            detailPresenter.loadPost(post);
                    }
                });
    }

    @Override
    public void loadComments() {
        mForum.getApi().getComments(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<Comment>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (detailPresenter != null)
                            detailPresenter.onFail(e.toString());
                    }

                    @Override
                    public void onNext(List<Comment> comments) {
                        if (comments == null || comments.size() == 0)
                            detailPresenter.onFail("");
                        else if (detailPresenter != null)
                            detailPresenter.loadComments(comments);
                    }
                });
    }
}
