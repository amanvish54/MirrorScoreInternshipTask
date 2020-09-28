package com.example.internshiptask;

public class PostFetchResponse {
    private int ResponseCode;
    private String Comments,ResponseMessage;
    private Result Result;

    public PostFetchResponse(int responseCode, String comments, String responseMessage, com.example.internshiptask.Result result) {
        ResponseCode = responseCode;
        Comments = comments;
        ResponseMessage = responseMessage;
        Result = result;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public String getComments() {
        return Comments;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public com.example.internshiptask.Result getResult() {
        return Result;
    }
}

