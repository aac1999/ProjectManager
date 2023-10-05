package com.example.lab3.Project.model;

import com.example.lab3.Project.TaskPrio;
import com.example.lab3.Project.TaskState;

import java.io.Serializable;
import java.time.LocalDate;


/**
 This Class is used to create, handle and compare individual Tasks.
 @author Adil Chohan, Roman Luis Furman
 */
public class Task implements Comparable<Task>, Serializable {

    private final String descriptions;
    private final int id;
    private String Takenby;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    /**
     * Constructs and creates a Task
     * @param descriptions The description of a task
     * @param prio The chosen priority of a task
     * @param id The identification of a task
     */
    Task(String descriptions, TaskPrio prio, int id) {
        this.descriptions = descriptions;
        this.id = id;
        this.Takenby = "";
        this.state = TaskState.TO_DO;
        this.lastUpdate = LocalDate.now();
        this.prio = prio;
    }

    /**
     * Takes a name and gives them the Task and updates the time. M
     * akes sure that the task isn't already in progress
     * @param takenBy The Name of the Occupant
     * @throws IllegalStateException if the Task is already in progress
     */

    public void setTakenBy(String takenBy) {
        if (this.state == TaskState.IN_PROGRESS) throw new IllegalStateException("Task In Progress");
        Takenby = takenBy;
        this.lastUpdate = LocalDate.now();
    }

    /**
     * Changes the state of a Task.
     * @param state the chosen state of a task
     */

    public void setState(TaskState state) {
        this.state = state;
        this.lastUpdate = LocalDate.now();
    }

    /**
     * Changes the current priority of a Task
     * @param prio the chosen priority of a task
     */

    public void setPrio(TaskPrio prio) {
        this.prio = prio;
        this.lastUpdate = LocalDate.now();
    }

    /**
     * Compares two tasks either on their priorities or their description.
     * first object is larger if the result is 1> and smaller if the result is 1<
     * @param other the object to be compared.
     * @return a number that tells which task is larger
     */

    @Override
    public int compareTo(Task other) {
        int result = this.prio.ordinal() - other.prio.ordinal();
        if (result == 0) {
            result = this.descriptions.compareTo(other.descriptions);
        }
        return result;
    }

    /**
     * access-method to get access to the task's description.
     * @return returns the description
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * access-method to get access to the task's ID.
     * @return returns the ID
     */
    public int getId() {
        return id;
    }

    /**
     * access-method to get access to the task's occupant.
     * @return returns the occupant of the task
     */
    public String getTakenby() {
        return Takenby;
    }

    /**
     * access-method to get access to the task's current state.
     * @return returns the current state of the task
     */
    public TaskState getState() {
        return state;
    }

    /**
     * access-method to get access to the task's current priority.
     * @return returns the current priority of a task
     */
    public TaskPrio getPrio() {
        return prio;
    }

    /**
     * access-method to get information on when the task was last updated.
     * @return returns the time when the task was last updated.
     */
    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    /**
     * compares two tasks to see whether they are equal to each other.
     * @param other the other task to be compared with.
     * @return a boolean value. True if both tasks are equal, false if not.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof Task) {
            Task otherTask = (Task) other;
            return this.compareTo(otherTask) == 0;
        }
        return false;
    }

    /**
     * gives the user a string representation of the task.
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return  "\n             Task: " + id +
                "  |  Descriptions: " + descriptions +
                "\n             -----------------------------------" +
                "\n             Taken by: "+ Takenby  +
                "\n             State: " + state +
                "\n             Last update: " + lastUpdate +
                "\n             Priority: " + prio + "\n";
    }
}
