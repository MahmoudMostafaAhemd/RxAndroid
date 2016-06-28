package com.example.mahmoud.rxandroid.MainView.ui;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mahmoud.rxandroid.MainView.presenter.MainInterface;
import com.example.mahmoud.rxandroid.R;
import com.example.mahmoud.rxandroid.MainView.adapter.ListAdapter;
import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.MainView.presenter.ListPresenter;
import com.example.mahmoud.rxandroid.MainView.presenter.RxMainPresenter;

import java.util.List;

public class MainActivity extends FragmentActivity implements ListPresenter {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ListAdapter listAdapter;
    MainInterface mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiRecyclerView();
        mainPresenter = new RxMainPresenter(this);
        mainPresenter.loadPosts();
    }

    private void intiRecyclerView() {
        listAdapter = new ListAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
    }


    @Override
    public void loadPosts(List<Post> posts) {
        listAdapter.addItems(posts);
    }

    @Override
    public void onFail(String message) {
        Log.d("onFailTag", message);
    }
}
