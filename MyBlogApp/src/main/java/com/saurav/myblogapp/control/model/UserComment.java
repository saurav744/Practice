package com.saurav.myblogapp.control.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String body;
	private Date addedDate;
	@ManyToOne
	private User user;
	@ManyToOne
	private Publication publication;

	public UserComment(String body, User user, Date date) {
		this.body = body;
		this.user = user;
		this.addedDate = date;
	}

	public UserComment() {
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
