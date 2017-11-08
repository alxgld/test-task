package com.gladunalexander.test_task.exceptions.exception_handler;

import com.gladunalexander.test_task.exceptions.CompanyNotFoundException;
import com.gladunalexander.test_task.exceptions.DepartmentNotFoundException;
import com.gladunalexander.test_task.exceptions.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class })
    protected ResponseEntity<Object> handleUserFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "User not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ CompanyNotFoundException.class })
    protected ResponseEntity<Object> handleCompanyFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Company not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ DepartmentNotFoundException.class })
    protected ResponseEntity<Object> handleDepartmentFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Department not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
