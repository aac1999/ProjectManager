package com.example.lab3.Project;

import com.example.lab3.Project.model.ITaskMatcher;
import com.example.lab3.Project.model.Task;

public class NotDoneMatcher implements ITaskMatcher {
    @Override
    public boolean match(Task task) {
        if(task.getState() != TaskState.DONE) {
            return true;
        }
        return false;
    }
}
