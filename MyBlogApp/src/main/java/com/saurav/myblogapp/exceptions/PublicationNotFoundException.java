package com.saurav.myblogapp.exceptions;

public class PublicationNotFoundException extends Exception {

    @Override
    public String toString() {
        return "Publication not found";
    }
}
