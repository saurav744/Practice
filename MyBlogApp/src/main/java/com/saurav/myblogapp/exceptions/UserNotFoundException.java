package com.saurav.myblogapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="This user is not found in the system")
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
    public String toString() {
        return "User not found";
    }
}
