package com.example.mahmoud.rxandroid.servecies;

import com.example.mahmoud.rxandroid.commentsView.model.Comment;
import com.example.mahmoud.rxandroid.MainView.model.Post;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by mahmoud on 6/28/16.
 */
public interface ForumApi {
    @GET("/posts")
    public Observable<List<Post>>
    getPosts();

    @GET("/posts/{id}")
    public Observable<Post>
    getPost(@Path("id") int postId);

    @GET("/comments")
    public Observable<List<Comment>>
    getComments(@Query("postId") int postId);

    @POST("/posts")
    public Observable<Post>
    postPost(Post post);
}
