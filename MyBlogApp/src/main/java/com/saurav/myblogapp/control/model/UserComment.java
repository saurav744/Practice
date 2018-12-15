package com.saurav.myblogapp.control.model;

import java.util.Date;

public class UserComment {

    private String id;
    private String body;
    private Date addedDate;
    private User user;

    public UserComment(String body, User user, Date date) {
        this.body = body;
        this.user = user;
        this.addedDate = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public User getUser() {
        return user;
    }

}
