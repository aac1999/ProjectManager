package com.example.lab3.Project;

public class TitleNotUniqueException extends RuntimeException{

    public TitleNotUniqueException() {
        super();
    }

    public TitleNotUniqueException(String msg) {
        super(msg);
    }
}
