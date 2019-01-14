package com.saurav.myblogapp.exceptions;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
    public String toString() {
        return "User not found";
    }
}
