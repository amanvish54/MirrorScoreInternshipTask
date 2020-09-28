package com.example.internshiptask;

public class Data {
    private int postId,userId;
    private String userName,text, image, createdOn, updatedOn,studentClass, studentBoard, subject, answerCount, upvoteCount, upvoted, reportCount, reported;

    public Data(int postId, int userId, String userName, String text, String image, String createdOn, String updatedOn, String studentClass, String studentBoard, String subject, String answerCount, String upvoteCount, String upvoted, String reportCount, String reported) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.image = image;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.studentClass = studentClass;
        this.studentBoard = studentBoard;
        this.subject = subject;
        this.answerCount = answerCount;
        this.upvoteCount = upvoteCount;
        this.upvoted = upvoted;
        this.reportCount = reportCount;
        this.reported = reported;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getStudentBoard() {
        return studentBoard;
    }

    public String getSubject() {
        return subject;
    }

    public String getAnswerCount() {
        return answerCount;
    }

    public String getUpvoteCount() {
        return upvoteCount;
    }

    public String getUpvoted() {
        return upvoted;
    }

    public String getReportCount() {
        return reportCount;
    }

    public String getReported() {
        return reported;
    }
}
