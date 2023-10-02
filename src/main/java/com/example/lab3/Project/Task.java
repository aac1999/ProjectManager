package com.example.lab3.Project;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable { //Tror det ska vara Comparable<Task>?

    private String descriptions;
    private int id;
    private String Takenby;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    public Task(String descriptions, TaskPrio prio, int id) { //den ska vara package private (~) ?
        this.descriptions = descriptions;
        this.id = id;
        Takenby = null; //lagt till null
        this.state = TaskState.TO_DO; //lagt till state=TO_DO
        this.lastUpdate = lastUpdate; //osäker?
        this.prio = prio;
    }

    public void setTakenby(String takenby) {
        Takenby = takenby;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setPrio(TaskPrio prio) {
        this.prio = prio;
    }

    @Override
    public int compareTo(Task other) {
        //TODO: Implement
        return 0;
    }
}
