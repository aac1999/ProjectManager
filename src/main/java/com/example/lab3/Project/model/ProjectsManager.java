package com.example.lab3.Project.model;
import com.example.lab3.Project.model.Project;
import com.example.lab3.Project.*;
import com.example.lab3.Project.ui.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectsManager {
    private ArrayList<Project> projects;
    private int nextProjectId; //Ska den vara int, står ej i instruktioner?

    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = 0;
    }

    public void setProjects(List<Project> incomingProjects) {
        projects.clear();
        projects.addAll(incomingProjects);
        this.nextProjectId = projects.size();
        //nextProjectId++;
    }

    public Project addProject(String title, String description) {
        if(isTitleUnique(title)) throw new TitleNotUniqueException();
        Project p = new Project(title, description, nextProjectId++);
        projects.add(p);
        return p;
    }

    public boolean isTitleUnique(String title) {

        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void removeProject(Project project) {
        //Säkerställ att den är rätt
        projects.remove(project);
    }


    public ArrayList<Project> getProjects() {
        //Getter
        ArrayList<Project> copy = new ArrayList<>();
        copy.addAll(projects);
        return copy; //test
    }
    public Project getProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
        //eller exception?
    }



    public List<Project> findProjects(String title) {
        List<Project> find = new ArrayList<>();
        Collections.sort(projects); //sortering
        //System.out.println("Sorted: " + tasks); kan testas hårdkodat i main, ta bort innan inlämning!
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                find.add(project);
            }
        }
        return find;
    }

    public int getNextProjectId() {
        //Getter
        return nextProjectId;
    }

    private int getHighestId() {
        /* int highestId = projects.get(0).getId(); //ska vara 0?
        for (int i = 0; i < projects.size(); i++) {
            int currentId = projects.get(i).getId();
            if (currentId > highestId) {
                highestId = currentId; // Update the highest ID
            }
        }
        return highestId; */
        return nextProjectId;
    }

    @Override
    public String toString() {
        return "Projects Manager" +
                "\n-----------------";
    }
}
