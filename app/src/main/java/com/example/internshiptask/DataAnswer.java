package com.example.internshiptask;

public class DataAnswer {
    int answerId, userid, postId, replyCount, upvoteCount, reportCount;
    Boolean upvoted, reported;
    String userName, text, image, createdOn, updatedOn;

    public DataAnswer(int answerId, int userid, int postId, int replyCount, int upvoteCount, int reportCount, Boolean upvoted, Boolean reported, String userName, String text, String image, String createdOn, String updatedOn) {
        this.answerId = answerId;
        this.userid = userid;
        this.postId = postId;
        this.replyCount = replyCount;
        this.upvoteCount = upvoteCount;
        this.reportCount = reportCount;
        this.upvoted = upvoted;
        this.reported = reported;
        this.userName = userName;
        this.text = text;
        this.image = image;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getAnswerId() {
        return answerId;
    }

    public int getUserid() {
        return userid;
    }

    public int getPostId() {
        return postId;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public int getUpvoteCount() {
        return upvoteCount;
    }

    public int getReportCount() {
        return reportCount;
    }

    public Boolean getUpvoted() {
        return upvoted;
    }

    public Boolean getReported() {
        return reported;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }
}
