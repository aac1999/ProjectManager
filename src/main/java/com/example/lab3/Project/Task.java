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

    Task(String descriptions, TaskPrio prio, int id) {
        //ska vara package-private (~) så ingen private/public i början?
        this.descriptions = descriptions;
        this.id = id;
        this.Takenby = null; //lagt till null
        this.state = TaskState.TO_DO;
        this.lastUpdate = LocalDate.now();
        this.prio = prio;
    }

    public void setTakenby(String takenby) {
        if(this.state == TaskState.IN_PROGRESS) throw new IllegalStateException("Task In Progress");
        Takenby = takenby;
        this.lastUpdate = LocalDate.now();
    }

    public void setState(TaskState state) {
        this.state = state;
        this.lastUpdate = LocalDate.now();
    }

    public void setPrio(TaskPrio prio) {
        this.prio = prio;
        this.lastUpdate = LocalDate.now();
    }

    @Override
    public int compareTo(Task other) {
        //jämför prio(första nyckeln) och description (andra nyckeln)
        int result = this.prio.ordinal() - other.prio.ordinal();
        if(result == 0) {
            result = this.descriptions.compareTo(other.descriptions); //fråga Anders OM RÄTT
        }
        return result;
    }
}
