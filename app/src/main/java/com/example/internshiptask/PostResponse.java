package com.example.internshiptask;

public class PostResponse {
    private int ResponseCode;
    private String Comments,ResponseMessage;
    private Data Result;

    public PostResponse(int responseCode, String comments, String responseMessage, Data result) {
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

    public Data getResult() {
        return Result;
    }
}
