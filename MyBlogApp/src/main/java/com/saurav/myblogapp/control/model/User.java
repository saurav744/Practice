package com.saurav.myblogapp.control.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserType type;
    private List<Publication> publications;
    private List<Long> likedPubs;

    public User(String firstName, String lastName, String email, String password) {

        this(firstName, lastName, email, password, UserType.BLOGGER);
    }

    public User(String firstName, String lastName, String email, String password, UserType type) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.publications = new ArrayList<>();
        this.likedPubs = new ArrayList<>();
    }

    @Override
    public int hashCode() {

        return email.hashCode();

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this){
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }

        User user = (User) obj;
        return user.getEmail().equals(email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public List<Long> getLikedPubs() {
        return likedPubs;
    }

    public void addLiked_pubs(Long id) {
        this.likedPubs.add(id);
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void addPublications(Publication publication) {
        this.publications.add(publication);
    }

    public void setType(UserType type) {
        this.type = type;
    }

}
