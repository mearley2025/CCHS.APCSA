/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment53;
import java.util.*;

/**
 *
 * @author mearley2025
 */
public class Assignment53 {

    public static void main(String[] args) {
        //making a student and their profile
        Student s1 = new Student("Maggie", "Smith");
        s1.setCourse("Math", "Biology", "English");
        s1.setCoursetest(90, 96, 47);
        
       System.out.print(s1);
    }
}

class Student {
    private String firstName, lastName;
    private String course1, course2, course3;
    private int c1test, c2test, c3test;

    //constructors
    public Student(){
        firstName = "";
        lastName = "";
        course1 = "";
        course2 = "";
        course3 = "";
        c1test = 0;
        c2test = 0;
        c3test = 0;
    }
    public Student(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    //setting courses
     public void setCourse(String courseOne, String courseTwo, String courseThree){
        course1 = courseOne;
        course2 = courseTwo;
        course3 = courseThree;
     }
     //gettting courses
     public String[] getCourse(){
        return new String[]{course1, course2, course3};
     }
     
     //setting corresponding course test
     public void setCoursetest(int c1Test, int c2Test, int c3Test){
        c1test = c1Test;
        c2test = c2Test;
        c3test = c3Test;
     }
     //getting corresponding course test
     public int[] getCourseTest(){
         return new int[] {c1test, c2test, c3test};
     }
    

    public String toString() {
        String result;
        result = "Student: " + firstName + " " + lastName + "\n" +
                "Courses and their grade:\n" + course1 + " - " + c1test + "%\n" + course2 + " - " + c2test + "%\n" + course3 + " - " + c3test + "%";
        return result;
    }
}