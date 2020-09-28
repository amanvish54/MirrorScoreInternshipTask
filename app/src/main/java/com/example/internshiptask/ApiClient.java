package com.example.internshiptask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static final String BASE_URL = "https://mirrorscore-android.herokuapp.com/ ";
    private static ApiClient mInstance;
    private static Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiClient getInstance(){
        if (mInstance==null){
            mInstance = new ApiClient();
        }
        return mInstance;
    }

    public UserService getApi(){
        return retrofit.create(UserService.class);
    }
}
