package com.example.internshiptask;

public class LoginResponse {
    private int ResponseCode;
    private String Comments;
    private String ResponseMessage;
    private Result Result;

    public LoginResponse(int responseCode, String comments, String responseMessage, com.example.internshiptask.Result result) {
        ResponseCode = responseCode;
        Comments = comments;
        ResponseMessage = responseMessage;
        Result = result;
    }

    public com.example.internshiptask.Result getResult() {
        return Result;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public String getComments() {
        return Comments;
    }


}
