package com.example.lab3.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Project implements Comparable<Project>, Serializable {

    private String title;
    private int id;
    private String description;
    private int nextTaskId;
    private ArrayList<Task> tasks;
    private LocalDate localDate;

    Project(String title, String description, int id) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.nextTaskId = 0;    // antar att det ska börja från noll?
        this.localDate =  LocalDate.now();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Task addTask(String description, TaskPrio prio) {
        Task task = new Task(description, prio, nextTaskId++);  // ej säker på denna!
        return task;
    }

    public ProjectState getProjectState() {
        if (tasks.isEmpty()) {
            return ProjectState.EMPTY;
        }
        else if (tasks.containsAll(Collections.singleton(TaskState.DONE))) {
            return ProjectState.COMPLETED;
        }
        else return ProjectState.ONGOING;
    }


    @Override
    public int compareTo(Project o) {
        return 0;
    }
}
