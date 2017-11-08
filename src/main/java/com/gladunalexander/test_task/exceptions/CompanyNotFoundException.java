package com.gladunalexander.test_task.exceptions;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */
public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }

    public CompanyNotFoundException(Throwable cause) {
        super(cause);
    }
}
