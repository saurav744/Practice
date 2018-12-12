package com.saurav.myblogapp.control.model;

import java.util.Date;

public class Comment {

    private String body;
    private Date added_date;
    private User user;

    public Comment(String body, User user, Date date) {
        this.body = body;
        this.user = user;
        this.added_date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }

    public User getUser() {
        return user;
    }

}
