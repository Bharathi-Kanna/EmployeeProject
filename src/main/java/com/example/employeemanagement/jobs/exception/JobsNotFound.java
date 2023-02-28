package com.example.employeemanagement.jobs.exception;

public class JobsNotFound extends RuntimeException{

    public JobsNotFound(String message) {
        super(message);
    }
}
