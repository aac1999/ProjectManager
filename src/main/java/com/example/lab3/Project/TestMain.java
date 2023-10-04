package com.example.lab3.Project;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        Project project = new Project("My project", "work", 0);



        System.out.println(project.toString() + "\n");
        project.addTask("My task", TaskPrio.Low);
        project.addTask("Another task", TaskPrio.High);
        project.addTask("Third task", TaskPrio.High);
        System.out.println(project.getTasks());
        project.removeTask(project.getTaskById(1));
        project.addTask("task 4", TaskPrio.Medium);
        System.out.println("test" + project.getTaskById(4));


    }
}