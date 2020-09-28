package com.example.internshiptask;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    String TAG = "MyTag";
    TextView mEmail, mPassword;
    Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = findViewById(R.id.user_email);
        mPassword = findViewById(R.id.user_password);
        mLoginBtn = findViewById(R.id.loginbtn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processLogin();
            }
        });
    }

    public void processLogin() {
        if (mEmail.getText().toString().isEmpty() || mPassword.getText().toString().isEmpty()){
            mEmail.setError("Please Enter Valid Fields");
            return;
        }

       Call<LoginResponse> loginResponseCall = ApiClient.getInstance().getApi().userLogin(mEmail.getText().toString(),mPassword.getText().toString());
       loginResponseCall.enqueue(new Callback<LoginResponse>() {
           @Override
           public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               LoginResponse loginResponse = response.body();
               //Log.d("MyTag", "onResponse: "+ loginResponse);
               assert loginResponse != null;
               Intent intent = new Intent(getApplicationContext(),DiscussionWallActivity.class);
               intent.putExtra("ACCESS_TOKEN",loginResponse.getResult().getToken().getAccess());
               intent.putExtra("USER_ID",String.valueOf(loginResponse.getResult().getUserId()));
               intent.putExtra("REFRESHED_TOKEN",loginResponse.getResult().getToken().getRefresh());

               startActivity(intent);
               finish();


           }

           @Override
           public void onFailure(Call<LoginResponse> call, Throwable t) {
               Log.d("MyTag", "onFailure: "+ t.getLocalizedMessage());

           }
       });


    }
}