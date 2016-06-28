package com.example.mahmoud.rxandroid.commentsView.ui;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.mahmoud.rxandroid.R;
import com.example.mahmoud.rxandroid.commentsView.adapter.CommentsAdapter;
import com.example.mahmoud.rxandroid.commentsView.model.Comment;
import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.commentsView.presenter.CommentsPresenter;
import com.example.mahmoud.rxandroid.commentsView.presenter.DetailPresenter;
import com.example.mahmoud.rxandroid.commentsView.presenter.RxCommentsPresenter;
import com.example.mahmoud.rxandroid.servecies.ForumService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CommentsActivity extends FragmentActivity implements DetailPresenter{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CommentsAdapter commentsAdapter;
    ForumService mForum;
    RxCommentsPresenter commentsPresenter;
    TextView textViewTitle, textViewBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        initRecyclerView();
    }

    private void initRecyclerView(){
        mForum = new ForumService();
        commentsAdapter = new CommentsAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(commentsAdapter);
        textViewBody = (TextView)findViewById(R.id.textViewBody);
        textViewTitle = (TextView)findViewById(R.id.textViewTitle);
        commentsPresenter = new CommentsPresenter(this,getIntent().getIntExtra("postId", 0));
        commentsPresenter.loadPost();
        commentsPresenter.loadComments();
    }

    @Override
    public void loadPost(Post post) {
        textViewTitle.setText(post.title);
        textViewBody.setText(post.body);
    }

    @Override
    public void loadComments(List<Comment> comments) {
        commentsAdapter.addItems(comments);
    }

    @Override
    public void onFail(String error) {
        Log.d("onFailTag", error);
    }
}
