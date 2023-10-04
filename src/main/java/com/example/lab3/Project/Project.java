package com.example.lab3.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Project implements Comparable<Project>, Serializable, ITaskMatcher {

    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    private ArrayList<Task> tasks;

    Project(String title, String description, int id) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.nextTaskId = 0;    // antar att det ska börja från noll?
        this.created =  LocalDate.now();
        this.tasks = new ArrayList<>();
    }

    public Task getTaskById(int id) throws IndexOutOfBoundsException {
        //ändrat så att den matchar med taskens faktiska id
        //istället för dess position
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new NoMatchingIdException("No matching ID");
        // eller return null?
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> copy = new ArrayList<>();
        copy.addAll(tasks);
        return copy;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public int getNextTaskId() {
        return nextTaskId;
    }

    public Task addTask(String description, TaskPrio prio) {
        Task t = new Task(description, prio, nextTaskId++);  // ej säker på denna!
        tasks.add(t);
        return t;
    }

    public boolean removeTask(Task task) {
        boolean removed = tasks.remove(task);
        return removed;
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

    public LocalDate getLastUpdated() {
        // funkar endast om jag lagt till getLastUpdate() i Task.java
        if (!tasks.isEmpty()) {
            LocalDate date = tasks.get(0).getLastUpdate();
            for (int i = 1; i < tasks.size(); i++) {
                if (date.isBefore(tasks.get(i).getLastUpdate())) {
                    date = tasks.get(i).getLastUpdate();
                }
            }
            return date;
        }
            return this.created;
    }

    public List<Task> findTasks(ITaskMatcher matcher) {
        List<Task> find = new ArrayList<>();
        for (Task task : tasks) {
            if (matcher.match(task)) {
                find.add(task);
            }
        }
        return find;
    }

    @Override
    public int compareTo(Project other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public boolean equals(Object other) {
        //Gjorde samma som vi hade i Task.
        if (this == other) return true;
        if(other instanceof Project) {
            Project otherProject = (Project) other;
            return this.compareTo(otherProject) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", nextTaskId=" + nextTaskId +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean match(Task tasks) {
        return false;
    }
}
