package com.example.internshiptask;

import java.util.List;

public class Result {

    private int userId;
    private Token token;
    private int count;

    private List<Data> data;

    public Result(int userId, Token token) {
        this.userId = userId;
        this.token = token;
    }

    public Result(int count, List<Data> data) {
        this.count = count;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public List<Data> getData() {
        return data;
    }

    public int getUserId() {
        return userId;
    }

    public Token getToken() {
        return token;
    }
}
