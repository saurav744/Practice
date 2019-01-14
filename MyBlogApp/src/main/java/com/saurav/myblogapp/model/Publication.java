package com.saurav.myblogapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Publication {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    private String title;
    private String body;
    private long likes;
    private Date added_date;
    private PublicationState state;
    private PublicationType type;
    
    @ManyToMany(mappedBy="publications")
    private List<User> authors;
  // private List<UserComment> comments;


    public Publication() {
    	
    	this.authors = new ArrayList<>();
    	
	}

	public Publication(String title, String body, User author, Date date, PublicationType type) {
        this.title = title;
        this.body = body;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.added_date = date;
        this.likes = 0;
        this.state = PublicationState.PENDING;
//        this.comments = new ArrayList<>();
        this.type = type;

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

    public void incrementLikes() {
        this.likes++;
    }

    public Date getAddedDate() {
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

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public List<User> getAuthors() {
        return authors;
    }

    public void addAuthor(User author) {
        this.authors.add(author);
    }

}
