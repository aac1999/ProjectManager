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
        this.nextProjectId = 0; //antar att det ska börja från 0?
    }

    public void setProjects(List<Project> incomingProjects) {
        projects.clear();
        //lägg till projects ? (incomingProjects)
        projects.addAll(incomingProjects);
        nextProjectId++;
    }

    public Project addProject(String title, String description) {
        //kontrollera att titeln är unik med hjälp av isTitleUnique, om ej, släng TitleNotUniqueException
        if(isTitleUnique(title)) throw new TitleNotUniqueException(); //kontrollera senare om det rätt
        Project p = new Project(title, description, nextProjectId++);
        projects.add(p);
        return p;
    }

    public boolean isTitleUnique(String title) { //TROR JAG HAR GJORT RÄTT MEN OSÄKER
        //ska kolla om titeln är unik eller ej
        for (int i = 1; i < projects.size(); i++) {
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
        int highestId = projects.get(0).getId();
        for (int i = 1; i < projects.size(); i++) {
            int currentId = projects.get(i).getId();
            if (currentId > highestId) {
                highestId = currentId; // Update the highest ID
            }
        }
        return highestId;
    }

    @Override
    public String toString() {
        return "ProjectsManager{" +
                "projects=" + projects +
                ", nextProjectId=" + nextProjectId +
                '}';
    }
}
