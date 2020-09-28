package com.example.internshiptask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailsActivity extends AppCompatActivity {
    String postId, userId, userName, text, image, createdOn, updatedOn, studentClass, studentBoard, subject, answerCount, upvoteCount, upvoted, reportCount, reported;
    TextView user_name_post_detail, time_post_detail, standard_post_detail, question_post_detail, card_view_text;
    String accesstoken;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        user_name_post_detail = findViewById(R.id.user_name_post_detail);
        time_post_detail = findViewById(R.id.time_post_detail);
        standard_post_detail = findViewById(R.id.standard_post_detail);
        question_post_detail = findViewById(R.id.question_post_detail);
        card_view_text = findViewById(R.id.card_view_text);


        Intent intent = getIntent();
        postId = intent.getStringExtra("postId");
        userId = intent.getStringExtra("userId");
        userName = intent.getStringExtra("userName");
        text = intent.getStringExtra("text");
        image = intent.getStringExtra("image");
        createdOn = intent.getStringExtra("createdOn");
        updatedOn = intent.getStringExtra("updatedOn");
        studentClass = intent.getStringExtra("studentClass");
        studentBoard = intent.getStringExtra("studentBoard");
        subject = intent.getStringExtra("subject");
        answerCount = intent.getStringExtra("answerCount");
        upvoteCount = intent.getStringExtra("upvoteCount");
        upvoted = intent.getStringExtra("upvoted");
        reportCount = intent.getStringExtra("reportCount");
        reported = intent.getStringExtra("reported");
        accesstoken = intent.getStringExtra("accesstoken");
        Log.d("Mytag",subject+" "+ studentClass);

        user_name_post_detail.setText(userName);
        time_post_detail.setText(createdOn);
        standard_post_detail.setText(studentBoard+" "+studentClass);
        question_post_detail.setText(text);
        card_view_text.setText("Answer "+answerCount);
        Log.d("Mytag","Set Text Successfully" + accesstoken + "\n"+ postId);
        fetchAnswers();
    }

    private void fetchAnswers() {
        Call<AnswerFetchResponse> call = ApiClient.getInstance().getApi().fetchAnswer("discussionWall/answer?userId="+userId,
                "Bearer "+ accesstoken, Integer.parseInt(postId));
        call.enqueue(new Callback<AnswerFetchResponse>() {
            @Override
            public void onResponse(Call<AnswerFetchResponse> call, Response<AnswerFetchResponse> response) {
                AnswerFetchResponse answerFetchedResponse = response.body();
                Log.d("Mytag", "onResponse: hiii");
                assert answerFetchedResponse != null;

            }

            @Override
            public void onFailure(Call<AnswerFetchResponse> call, Throwable t) {

            }
        });
    }
}