package com.example.orm.testrunner.dto;

public class TestReport {
    private String name;
    private Status status;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public enum Status{
        SUCCESS,FAIL,ERROR,IN_PROGRESS,NOT_STARTED
    }

}
