package com.example.lab3.Project;

public class NotDoneMatcher implements ITaskMatcher {
    @Override
    public boolean match(Task task) {
        if(task.getState() != TaskState.DONE) {
            return true;
        }
        return false;
    }
}
