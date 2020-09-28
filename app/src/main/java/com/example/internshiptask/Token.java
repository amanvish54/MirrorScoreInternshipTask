package com.example.internshiptask;

public class Token {
    private String refresh, access;

    public Token(String refresh, String access) {
        this.refresh = refresh;
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public String getAccess() {
        return access;
    }
}
