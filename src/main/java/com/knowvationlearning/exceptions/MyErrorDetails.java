package com.knowvationlearning.exceptions;


import java.time.LocalDateTime;

public class MyErrorDetails {

    private LocalDateTime timestamps;
    private String message;
    private String uri;

    public MyErrorDetails(){

    }

    public MyErrorDetails(LocalDateTime timestamps, String message, String uri) {
        this.timestamps = timestamps;
        this.message = message;
        this.uri = uri;
    }

    public LocalDateTime getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(LocalDateTime timestamps) {
        this.timestamps = timestamps;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
