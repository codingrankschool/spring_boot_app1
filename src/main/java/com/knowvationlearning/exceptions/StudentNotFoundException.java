package com.knowvationlearning.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String msg){
        super(msg);
    }
}
