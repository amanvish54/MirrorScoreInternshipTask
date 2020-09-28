package com.example.internshiptask;

import java.util.List;

public class ResultAnswer {
    int count, postId, userId;
    String userName, text, image;
    List<DataAnswer> data;

    public ResultAnswer(int count, int postId, int userId, String userName, String text, String image, List<DataAnswer> data) {
        this.count = count;
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.image = image;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public List<DataAnswer> getData() {
        return data;
    }
}
