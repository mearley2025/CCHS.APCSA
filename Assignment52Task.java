/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment52task;

/**
 *
 * @author mearley2025
 */
import java.util.*;
public class Assignment52Task {

    public static void main(String[] args) {
         // make tasks with name, priority, and complexity
        Task t1 = new Task (3, 1, "Make Breakfast");
        Task t2 = new Task(1, 3, "Make Bed");
        Task t3 = new Task(2, 4, "Change into clothes for the day");
 
        // Create an array of tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        
        //compare tasks
        Collections.sort(tasks);
        
        // Print sorted task 
        System.out.println("Tasks sorted by priority and complexity: \n");
        for (Task task : tasks) {
            System.out.println(task);
       }
    }
}

class Task implements Priority, Complexity, Comparable<Task> {
    private int priority = 0;
    private int complexity = 0;
    private String taskName = "";
    
    // Constructor
    public Task(int priority, int complexity, String taskName) {
        this.priority = priority;
        this.complexity = complexity;
        this.taskName = taskName;
    }
    
    //setting task name
    public void setTaskName(String inName){
        taskName = inName;
    }//making input (to be set to different things in the objects) a string
    
    // Implementing Priority interface
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }
    
    // Implementing Complexity interface
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
    public int getComplexity() {
        return complexity;
    }

    // Implementing Comparable interface for task comparison
    @Override
    public int compareTo(Task otherTask) {
        //Comparing priotriy first
        int priorityComparison = Integer.compare(this.priority, otherTask.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        // If priorities are equal, compare complexity
        return Integer.compare(this.complexity, otherTask.complexity);
    }
//format for outprinted message
@Override
    public String toString() {
        return "Task: " + taskName + "\nPriority: " + priority + "\nComplexity: " + complexity + "\n";
    }
}


// Priority interface
interface Priority {
    public void setPriority(int priority);
    public int getPriority();
}
//Complexity interface
interface Complexity{
    public void setComplexity(int complexity);
    public int getComplexity();
}

