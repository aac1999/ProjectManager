package com.example.lab3.Project;

public enum TaskState {
    TO_DO("To do"), IN_PROGRESS("In progress"), DONE("Done");

    private final String str;

    private TaskState(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
