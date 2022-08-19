package com.example.retrofitapplication;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {


    // if url contains this format-> /posts?userId=1
    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);


    // if url contains this format->  /posts/1/comments
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    // if url contains this format-> /posts?userId=1&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") int userId,
            @Query("_sort") String sort
            ,
            @Query("_order") String order
    );


    // if url contains this format-> /posts?userId=1&_sort=id&_order=desc
    //with non premitive Integer
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer userId,
            @Query("userId") Integer userId2,
            @Query("_sort") String sort
            ,
            @Query("_order") String order
    );


    // if url contains this format-> /posts?userId=1&_sort=id&_order=desc
    //with non premitive Integer
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,

            @Query("_sort") String sort
            ,
            @Query("_order") String order
    );

    // if url contains this format-> /posts?userId=1&_sort=id&_order=desc
    //with non premitive Integer
    @GET("posts")
    Call<List<Post>> getPosts(
            @QueryMap Map<String, String> parameters
    );

    @GET
    Call<List<Comment>> getComments(@Url String url);


}
