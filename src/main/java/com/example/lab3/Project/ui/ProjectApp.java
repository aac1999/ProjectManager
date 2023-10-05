package com.example.lab3.Project.ui;

import com.example.lab3.Project.model.Project;
import com.example.lab3.Project.model.ProjectsManager;

import java.util.ArrayList;
import java.util.List;

public class ProjectApp {
    public static void main(String[] args) {

        //Kolla om main är rätt, verkar fungera?
        ProjectsManager magr = new ProjectsManager();
        MainUI ui = new MainUI(magr);
        ui.mainLoop();
    }
}
