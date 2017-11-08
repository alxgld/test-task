package com.gladunalexander.test_task.exceptions;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }
}
