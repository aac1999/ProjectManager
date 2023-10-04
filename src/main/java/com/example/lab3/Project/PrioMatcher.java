package com.example.lab3.Project;

import com.example.lab3.Project.model.ITaskMatcher;
import com.example.lab3.Project.model.Task;

public class PrioMatcher implements ITaskMatcher {
    private TaskPrio prio;

    public PrioMatcher(TaskPrio prio) {
        this.prio = prio;
    }

    @Override
    public boolean match(Task task) {
        return task.getPrio().equals(prio);
    }
}
