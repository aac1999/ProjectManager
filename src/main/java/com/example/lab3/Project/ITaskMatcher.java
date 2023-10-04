package com.example.lab3.Project;

public interface ITaskMatcher {

    /**

     Return true if the argument matches the criteria in the implementation
     this interface
     @param tasks the object to check for the criteria
     @return true if the argument matches the criteria
     */
    boolean match(Task tasks);
}
