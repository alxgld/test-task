package com.gladunalexander.test_task.exceptions;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
