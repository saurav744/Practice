package com.saurav.myblogapp.exceptions;

public class UserNotFoundException extends Exception {

    @Override
    public String toString() {
        return "User not found";
    }
}
