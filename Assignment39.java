/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment39;

/**
 *
 * @author mearley2025
 */


public class Assignment39 {

    public static void main(String[] args) {
        course course1 = new course("Computer Science", "AP CS A", 5, "Mr. Nelson");
        
        course course2 = new course("Mathematics");
        course2.setCourseCode("AP CALC BC");
        course2.setPointsTotal(5);
        course2.setInstructorName("Mr. Dahms");
        
        course course3 = new course("Biology", "AP Bio", 5, "Ms. Lopotka");

        // Print out each course's details using toString below
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
    }
}

class course {
    private String title;
    private String code;
    private int points;
    private String iname;
    
    public course (String title, String code, int points, String iname) {
        this.title = title;
        this.code = code;
        this.points = points;
        this.iname = iname;
    }//initialising variables
    
     public course (String title) {
        iname = title;
    }//constructor that accpets course name/title only
     
     
    // Accessor (getter) methods
    public String getTitle (){
        return title;
    }
    public String getCode (){
        return code;
    }
    public int getPoints (){
        return points;
    }
    public String getName (){
        return iname;
    }
    
    //Setter methods
    public void setCourseCode(String code) {
        this.code = code;
    }
    public void setPointsTotal(int points) {
        this.points = points;
    }
    public void setInstructorName(String iname) {
        this.iname = iname;
    }
    
    // toString method to return multi-line description of the course
    public String toString(){
        String result = ""; //returns the state of the object (class) as a string
        result = "Course title: " + title + 
                "\nInstructor name: " + iname + 
                " \nClass code: " + code + 
                "\nPoint Value: " + points + "\n";
        return result; 
    }
}