package com.example.lab3.Project;

import com.example.lab3.Project.model.ITaskMatcher;
import com.example.lab3.Project.model.Task;

public class TakenByMatcher implements ITaskMatcher {
    private String Takenby;

    public TakenByMatcher(String takenby) {
        this.Takenby = takenby;
    }

    @Override
    public boolean match(Task task) {
        return task.getTakenby().equals(Takenby);
    }
}
