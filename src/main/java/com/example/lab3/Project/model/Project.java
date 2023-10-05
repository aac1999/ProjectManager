package com.example.lab3.Project.model;

import com.example.lab3.Project.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 This Class is used to create and manage a project.
 Class has methods to add and remove different tasks & manage the project
 @author Adil Chohan, Roman Luis Furman
 */
public class Project implements Comparable<Project>, Serializable, ITaskMatcher {

    private final String title;
    private final int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    private ArrayList<Task> tasks;

    /**
     * Constructs and creates a project
     * @param title the title of the project
     * @param description the description of the project
     * @param id the identification of the project
     */
    Project(String title, String description, int id) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.nextTaskId = 0;    // antar att det ska börja från noll?
        this.created = LocalDate.now();
        this.tasks = new ArrayList<>();
    }

    /**
     * returns an individual task of a project based on its identification
     * @param id the identification of the task to be accessed
     * @return the given task based on its identification
     */
    public Task getTaskById(int id) {
        //ändrat så att den matchar med taskens faktiska id
        //istället för dess position
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
        // eller exception?
    }

    /**
     * returns a copy of the internal list of tasks with copies of the tasks in the list
     * @return the copy of the internal list of tasks.
     */
    public ArrayList<Task> getTasks() {
        ArrayList<Task> copy = new ArrayList<>();
        copy.addAll(tasks);
        return copy;
    }

    /**
     * returns the title of the project
     * @return the title of the project
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns the ID of the project
     * @return the ID of the project
     */
    public int getId() {
        return id;
    }

    /**
     * returns the description of the project
     * @return the description of the project
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the time a Project was created and initialized.
     * @return the time of the Project's creation
     */
    public LocalDate getCreated() {
        return created;
    }

    /**
     * returns the ID of the next task
     * @return the ID of the next task
     */
    public int getNextTaskId() {
        return nextTaskId;
    }

    /**
     * Adds a new task to the current project
     * The newly added task is given a unique ID which is calculated.
     * @param description the description of the new task
     * @param prio the chosen priority of the new task
     * @return returns the task back.
     */
    public Task addTask(String description, TaskPrio prio) {
        Task t = new Task(description, prio, nextTaskId++);  // ej säker på denna!
        tasks.add(t);
        return t;
    }

    /**
     * removes a task from the project and returns
     * @param task the given task to be removed
     * @return true or false if task has been removed
     */
    public boolean removeTask(Task task) {
        boolean removed = tasks.remove(task);
        return removed;
    }

    /**
     * returns the current state of the project. Returns empty if the list is empty
     * returns completed if all tasks are done, returns ongoing otherwise.
     * @return the current state of the project based on the status of all tasks.
     */
    public ProjectState getProjectState() {
        if (tasks.isEmpty()) {
            return ProjectState.EMPTY;
        } else if (tasks.containsAll(Collections.singleton(TaskState.DONE))) {
            return ProjectState.COMPLETED;
        } else return ProjectState.ONGOING;
    }

    /**
     * returns the date when a task was last updated, if the list is empty, the method
     * returns the date the project was created.
     * @return the date a task (or project if the list is empty) was created.
     */
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

    /**
     * this method implements interface ITaskMatcher and returns a list of the matched tasks
     * method sorts the list prior to returning the matched tasks
     * @param matcher gives either the priority, takenBy or State->NotDone that is searched after
     * @return the list of all successful matches
     */
    public List<Task> findTasks(ITaskMatcher matcher) {
        List<Task> find = new ArrayList<>();
        Collections.sort(tasks);
        //System.out.println("Sorted: " + tasks); kan testas hårdkodat i main, ta bort innan inlämning!
        for (Task task : tasks) {
            if (matcher.match(task)) {
                find.add(task);
            }
        }
        return find;
    }

    /**
     * Compares two projects based on their titles
     * @param other the project to be compared.
     * @return a number that tells you which one is larger
     */
    @Override
    public int compareTo(Project other) {
        return this.title.compareTo(other.title);
    }

    /**
     * compares two projects to see whether they are equal to each other.
     * @param other the other project to be compared with.
     * @return a boolean value. True if both projects are equal, false if not.
     */
    @Override
    public boolean equals(Object other) {
        //Gjorde samma som vi hade i Task.
        if (this == other) return true;
        if (other instanceof Project) {
            Project otherProject = (Project) other;
            return this.compareTo(otherProject) == 0;
        }
        return false;
    }

    /**
     * gives the user a string representation of the task.
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return  "\n      Project: " + id +
                "  |  Title: " + title +
                "  | Description: " + description +
                "   From: " + created +
                "\n      --------------------------------" +
                "--------------------------------" +
                "\n"+ tasks;
    }




    /**
     * This method is used in other methods to find matches based on certain criteria
     * @param tasks the object to check for the criteria
     * @return false
     */
    @Override
    public boolean match(Task tasks) {
        return false;
    }
}
