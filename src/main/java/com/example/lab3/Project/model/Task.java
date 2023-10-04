package com.example.lab3.Project.model;

import com.example.lab3.Project.TaskPrio;
import com.example.lab3.Project.TaskState;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable { //Tror det ska vara Comparable<Task>?

    private final String descriptions;
    private final int id;
    private String Takenby;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    public String getDescriptions() {
        return descriptions;
    }

    public int getId() {
        return id;
    }

    public String getTakenby() {
        return Takenby;
    }

    public TaskState getState() {
        return state;
    }

    public TaskPrio getPrio() {
        return prio;
    }

    Task(String descriptions, TaskPrio prio, int id) {
        //ska vara package-private (~) så ingen private/public i början?
        this.descriptions = descriptions;
        this.id = id;
        this.Takenby = null; //lagt till null
        this.state = TaskState.DONE;
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
            result = this.descriptions.compareTo(other.descriptions);
        }
        return result;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if(other instanceof Task) {
            Task otherTask = (Task) other;
            return this.compareTo(otherTask) == 0;
        }
        return false;
    }



    @Override
    public String toString() {
        return "\nTask{" +
                "descriptions='" + descriptions + '\'' +
                ", id=" + id +
                ", Takenby='" + Takenby + '\'' +
                ", state=" + state +
                ", lastUpdate=" + lastUpdate +
                ", prio=" + prio +
                '}';
    }
}
