package com.example.internshiptask;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UserService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );


    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET
    Call<PostFetchResponse> fetchPost(
            @Url String path,
            @Header("Authorization") String auth);

    @FormUrlEncoded
    @POST
    Call<PostResponse> createNewPost(
            @Url String url,
            @Header("Authorization") String auth,
            @Field("text") String text,
            @Field("image") String imagePath,
            @Field("subjectId") int subId
    );

    @FormUrlEncoded
    @POST
    Call<PostResponseNew> UpVoteReport(
            @Url String url,
            @Header("Authorization") String auth,
            @Field("postId") int postID
    );

    @GET
    Call<AnswerFetchResponse> fetchAnswer(
            @Url String url,
            @Header("Authorization") String access,
            @Query("postId") int postId
    );

}


