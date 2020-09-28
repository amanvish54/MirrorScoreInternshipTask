package com.example.internshiptask;

public class PostResponseNew {
    private int ResponseCode;
    private String Comments,ResponseMessage;
    private String Result;

    public int getResponseCode() {
        return ResponseCode;
    }

    public String getComments() {
        return Comments;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public String getResult() {
        return Result;
    }

    public PostResponseNew(int responseCode, String comments, String responseMessage, String result) {
        ResponseCode = responseCode;
        Comments = comments;
        ResponseMessage = responseMessage;
        Result = result;
    }



}
