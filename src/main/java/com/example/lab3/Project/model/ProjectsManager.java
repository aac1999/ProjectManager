package com.example.lab3.Project.model;
import com.example.lab3.Project.model.Project;
import com.example.lab3.Project.*;
import com.example.lab3.Project.ui.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 This Class is used to manage many Projects and works as a handler/manager
 @author Adil Chohan, Roman Luis Furman
 */
public class ProjectsManager {
    private ArrayList<Project> projects;
    private int nextProjectId;

    /**
     * Constructs and creates a new ProjectManager
     */
    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = 0;
    }

    /**
     * This method clears the list and then adds all projects given in the argument.
     * New value of ProjectID is calculated
     * @param incomingProjects the projects to be added
     */
    public void setProjects(List<Project> incomingProjects) {
        projects.clear();
        projects.addAll(incomingProjects);
        this.nextProjectId = projects.size();
    }

    /**
     * adds a single project to the Project list
     * @param title the title of the new Project
     * @param description the description of the new Project
     * @return the newly created Project
     * @throws TitleNotUniqueException if the title is already in use by a
     * different project
     */
    public Project addProject(String title, String description) {
        if(isTitleUnique(title)) throw new TitleNotUniqueException();
        Project p = new Project(title, description, nextProjectId++);
        projects.add(p);
        return p;
    }

    /**
     * Checks if a title is unique or not. If title is already in use, it returns true
     * @param title the title to be checked
     * @return true or false
     */
    public boolean isTitleUnique(String title) {

        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes a project from the list
     * @param project the project to be removed
     */
    public void removeProject(Project project) {
        projects.remove(project);
    }

    /**
     * This method takes an ID as an argument and checks for an existing project
     * with the given ID
     * @param id the ID of the project that is searched for.
     * @return the given project if it exists. Returns null otherwise.
     */
    public Project getProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }


    /**
     * This method searches for a project and returns the project with the given title.
     * @param title the title of the project that is searched after
     * @return the project that was searched for.
     */
    public List<Project> findProjects(String title) {
        List<Project> find = new ArrayList<>();
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                find.add(project);
            }
        }
        return find;
    }

    /**
     * returns a copy of the internal list of projects with copies of the projects in the list
     * @return the copy of the internal list of projects.
     */
    public ArrayList<Project> getProjects() {
        ArrayList<Project> copy = new ArrayList<>();
        copy.addAll(projects);
        return copy;
    }

    /**
     * Returns the ID that will be given to the next project that is created
     * @return the value of the ID
     */
    public int getNextProjectId() {
        return nextProjectId;
    }

    /**
     * Returns the value of the Highest ID that is currently in use.
     * @return the value of the highest ID
     */
    private int getHighestId() {
        int highestId = 0;
        for (int i = 0; i < projects.size(); i++) {
        int currentId = projects.get(i).getId();
            if (currentId > highestId) {
                 highestId = currentId;
                 }
             }
            return highestId;
    }

    /**
     * gives the user a string representation of the ProjectsManager class.
     * @return a string representation of the ProjectsManager class
     */
    @Override
    public String toString() {
        return "Projects Manager" +
                "\n-----------------";
    }
}
