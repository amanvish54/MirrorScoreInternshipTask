package com.example.internshiptask;

public class AnswerFetchResponse {

    int ResponseCode;
    String ResponseMessage, Comments;
    ResultAnswer Result;

    public AnswerFetchResponse(int responseCode, String responseMessage, String comments, ResultAnswer result) {
        ResponseCode = responseCode;
        ResponseMessage = responseMessage;
        Comments = comments;
        Result = result;
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

    public ResultAnswer getResult() {
        return Result;
    }
}
