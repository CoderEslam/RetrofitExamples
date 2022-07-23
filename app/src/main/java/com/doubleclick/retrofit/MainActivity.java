package com.doubleclick.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.doubleclick.Adapter.adapter;
import com.doubleclick.retrofit.Model.Post;
import com.doubleclick.retrofit.interfac.ApiInterface;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        post = findViewById(R.id.posts);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<Post>> call = apiInterface.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                assert response.body() != null;
                post.setAdapter(new adapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

        Call<List<Post>> idUser = apiInterface.getPostbyUserId("5");
        idUser.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.e("USER5", response.body().toString());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("USER5", t.getMessage());

            }
        });

        Call<Post> postId = apiInterface.getPostById(6);
        postId.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("POST6", response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("POST6", t.getMessage());
            }
        });


        Call<Post> postPost = apiInterface.postPost(new Post(6, "ESLAMGHAZY", "MYPOSTS"));
        postPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("postPostonResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("postPostonFailure", t.getMessage());
            }
        });


        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId", 7);
        map.put("title", "AnyThing");
        map.put("body", "SOMETHING");

        Call<Post> postPostMAP = apiInterface.postPostByHashMap(map);
        postPostMAP.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("postPostonResponseMAP", response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("postPostonFailureMAP", t.getMessage());
            }
        });

    }

}