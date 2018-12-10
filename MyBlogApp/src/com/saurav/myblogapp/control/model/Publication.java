package com.saurav.myblogapp.control.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Publication {

    private String title;
    private String body;
    private long likes;
    private Date added_date;
    private long id;
    private PublicationState state;

    private List<User> authors;
    private List<Comment> comments;


    public Publication(String title, String body, User author, Date date) {
        this.title = title;
        this.body = body;
        this.authors= new ArrayList<>();
        this.authors.add(author);
        this.added_date= date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PublicationState getState() {
        return state;
    }

    public void setState(PublicationState state) {
        this.state = state;
    }

    public List<User> getAuthors() {
        return authors;
    }

    public void setAuthors(List<User> authors) {
        this.authors = authors;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
