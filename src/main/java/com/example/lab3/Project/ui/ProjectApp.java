package com.example.lab3.Project.ui;

import com.example.lab3.Project.model.Project;
import com.example.lab3.Project.model.ProjectsManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProjectApp {

    public void run(){
    //
    }
    public static void main(String[] args) throws Exception {

        File f = new File("project1.ser");
        List<Project> p = ProjectsFileIO.deSerializeFromFile(f);
        ProjectsManager proj = new ProjectsManager();
        MainUI ui = new MainUI(proj);
        ui.mainLoop();
        ProjectsFileIO.serializeToFile(f, proj.getProjects());
    }
}
