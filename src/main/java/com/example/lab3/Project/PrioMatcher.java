package com.example.lab3.Project;

public class PrioMatcher implements ITaskMatcher{
    private TaskPrio prio;

    public PrioMatcher(TaskPrio prio) {
        this.prio = prio;
    }

    @Override
    public boolean match(Task task) {
        return task.getPrio().equals(prio);
    }
}
