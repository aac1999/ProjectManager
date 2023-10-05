package com.example.lab3.Project.ui;

import com.example.lab3.Project.model.Project;
import com.example.lab3.Project.model.ProjectsManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProjectApp {
    public static void main(String[] args) throws Exception {

        File f = new File("project1.ser");
        ProjectsFileIO.deSerializeFromFile(f); //Går endast o anropa efter filen är skapad, kommentera bort om filen saknas
        ProjectsManager magr = new ProjectsManager();
        MainUI ui = new MainUI(magr);
        ui.mainLoop();
        ProjectsFileIO.serializeToFile(f, magr.getProjects()); //osäker om getProjects?
    }
}
