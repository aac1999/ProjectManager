package com.example.lab3.Project;

import java.util.ArrayList;
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
        projects.addAll(incomingProjects);
        //lägg till projects ? (incomingProjects)
        nextProjectId++;
    }

    public Project addProject(String title, String description) {
        Project p = new Project(title, description, nextProjectId++);
        projects.add(p);
        return p;
    }

    public boolean isTitleUnique(String title) { //TROR JAG HAR GJORT RÄTT MEN OSÄKER
        //ska kolla om titeln är unik eller ej
        for (int i = 1; i < projects.size(); i++) {
            if (projects.get(i).getTitle() == title) {
                return true;
            }
        }
        return false;
    }
}
