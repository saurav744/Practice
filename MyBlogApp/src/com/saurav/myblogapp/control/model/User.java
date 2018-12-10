package com.saurav.myblogapp.control.model;

public class User {

    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private UserType type;

    //private List<Publication> publications;

    public User(String first_name, String last_name, String email, String password) {

        this(first_name, last_name, email, password, UserType.BLOGGER);
    }

    public User(String first_name, String last_name, String email, String password, UserType type) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public void setType(UserType type) {
        this.type = type;
    }

}
