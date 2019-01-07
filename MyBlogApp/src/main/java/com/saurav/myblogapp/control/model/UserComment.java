package com.saurav.myblogapp.control.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String body;
    private Date addedDate;
    @OneToOne(mappedBy = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id")
    private Publication publication;

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

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}
