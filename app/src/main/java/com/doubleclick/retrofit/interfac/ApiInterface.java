package com.doubleclick.retrofit.interfac;

import com.doubleclick.retrofit.Model.Post;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created By Eslam Ghazy on 7/23/2022
 */
public interface ApiInterface {

    @GET("posts/")
    public Call<List<Post>> getPost();

    @GET("posts/{id}")
    public Call<Post> getPostById(@Path("id") int postId);

    @GET("posts")
    public Call<List<Post>> getPostbyUserId(@Query("userId") String userId);

    @POST("posts")
    public Call<Post> postPost(@Body Post post);

    @POST("posts")
    public Call<Post> postPostByHashMap(@Body HashMap<Object,Object> post);
}
