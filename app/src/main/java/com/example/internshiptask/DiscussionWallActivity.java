package com.example.internshiptask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscussionWallActivity extends AppCompatActivity {
    EditText newQuestion;
    private String ACCESS_TOKEN;
    private String userId;
    private String refreshedToken;
    List<Data> postDataList;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    PostAdapter postAdapter = new PostAdapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_wall);
        Intent intent = getIntent();
        ACCESS_TOKEN = intent.getStringExtra("ACCESS_TOKEN");
        userId = intent.getStringExtra("USER_ID");
        refreshedToken = intent.getStringExtra("REFRESHED_TOKEN");
        recyclerView = findViewById(R.id.recycler_view_post);
        getPostData();
        newQuestion = findViewById(R.id.new_post_question);


    }

    private void getPostData() {

        Call<PostFetchResponse> postFetchResponseCall = ApiClient.getInstance().getApi().fetchPost("discussionWall/post?userId="+userId,"Bearer "+ACCESS_TOKEN);
        postFetchResponseCall.enqueue(new Callback<PostFetchResponse>() {
            @Override
            public void onResponse(Call<PostFetchResponse> call, Response<PostFetchResponse> response) {
                    PostFetchResponse postFetchResponse = response.body();
                    Log.d("MyTag", "onResponse: " + postFetchResponse);
                assert postFetchResponse != null;
                Log.d("MyTag", "onResponse: "+ postFetchResponse.getResult().getData());
                postDataList = postFetchResponse.getResult().getData();
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);
                postAdapter.setPostList(postDataList);
                postAdapter.setContext(DiscussionWallActivity.this);
                postAdapter.setUserId(userId);
                postAdapter.setAccessToken(ACCESS_TOKEN);
                recyclerView.setAdapter(postAdapter);
                postAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<PostFetchResponse> call, Throwable t) {
                Log.d("MyTag", "onFailure: "+ t.getLocalizedMessage());

            }
        });

    }

    public void processSendingPost(View view) {
        String question = newQuestion.getText().toString().trim();

        if (question.isEmpty()){
            newQuestion.setError("Please Enter a Question");
            return;
        }
        

        Call<PostResponse> postResponseCall = ApiClient.getInstance().getApi().createNewPost(
                "discussionWall/post?userId="+Integer.parseInt(userId),
                "Bearer "+ACCESS_TOKEN,
                question,
                "drawable/image.jpg",
                1
                );

        postResponseCall.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                PostResponse postResponse = response.body();
                assert postResponse != null;
                postDataList.add(0,postResponse.getResult());
                postAdapter.notifyDataSetChanged();
                newQuestion.setText("");

              }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });






    }
}