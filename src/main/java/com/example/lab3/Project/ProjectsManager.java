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
        //lägg till projects ? (incomingProjects)
        projects.addAll(incomingProjects);
        nextProjectId++;
    }

    public Project addProject(String title, String description) {
        //kontrollera att titeln är unik med hjälp av isTitleUnique, om ej, släng TitleNotUniqueException
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

    public ArrayList<Project> getProjects() {
        //Getter
        ArrayList<Project> copy = new ArrayList<>();
        copy.addAll(projects);
        return copy;
    }

    public int getNextProjectId() {
        //Getter
        return nextProjectId;
    }

    @Override
    public String toString() {
        return "ProjectsManager{" +
                "projects=" + projects +
                ", nextProjectId=" + nextProjectId +
                '}';
    }
}
