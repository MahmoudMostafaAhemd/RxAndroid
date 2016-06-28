package com.example.mahmoud.rxandroid;

import com.example.mahmoud.rxandroid.MainView.model.Post;
import com.example.mahmoud.rxandroid.MainView.presenter.AsyncMainPresenter;
import com.example.mahmoud.rxandroid.MainView.presenter.MainInterface;
import com.example.mahmoud.rxandroid.commentsView.presenter.CommentsUnitTest;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void checkPost() {
        DummyView dummyView = new DummyView();
        MainInterface mainInterface = new AsyncMainPresenter(dummyView);
        mainInterface.loadPosts();
        assertEquals(dummyView.isloadPostCalled, true);


    }

    @Test
    public void checkPostFail() {
        DummyView dummyView = new DummyView();
        AsyncMainPresenter mainInterface = new AsyncMainPresenter(dummyView);
        mainInterface.setListOfPost(null);
        mainInterface.loadPosts();
        assertEquals(dummyView.isloadPostCalled, false);
        assertEquals(dummyView.isFailCalled, true);


    }

    @Test
    public void checkPostFail2() {
        DummyView dummyView = new DummyView();
        AsyncMainPresenter mainInterface = new AsyncMainPresenter(dummyView);
        mainInterface.setListOfPost(Collections.<Post>emptyList());
        mainInterface.loadPosts();
        assertEquals(dummyView.isloadPostCalled, false);
        assertEquals(dummyView.isFailCalled, true);
    }

    @Test
    public void checkLoadComments() {
        DummyCommentsView dummyCommentsView = new DummyCommentsView();
        CommentsUnitTest commentsUnitTest = new CommentsUnitTest(dummyCommentsView);
        commentsUnitTest.loadComments();
        commentsUnitTest.loadPost();
        assertEquals(dummyCommentsView.isLoadCommentsCalled, true);
        assertEquals(dummyCommentsView.isFailCalled, false);
        assertEquals(dummyCommentsView.isLoadPostCalled, true);
        assertEquals(dummyCommentsView.isLoadCommentsFailed, false);
    }


}