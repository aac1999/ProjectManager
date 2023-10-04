package com.example.lab3.Project;

public class NoMatchingIdException extends RuntimeException{

    public NoMatchingIdException() {
        super();
    }

    public NoMatchingIdException(String msg) {
        super(msg);
    }
}
