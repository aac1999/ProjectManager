package com.example.lab3.Project;

public class TakenByMatcher implements ITaskMatcher{
    private String Takenby;

    public TakenByMatcher(String takenby) {
        this.Takenby = takenby;
    }

    @Override
    public boolean match(Task task) {
        return task.getTakenby().equals(Takenby);
    }
}
