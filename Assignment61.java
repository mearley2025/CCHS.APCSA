/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment61;

/**
 *
 * @author mearley2025
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Assignment61 {

    public static void main(String[] args) {
        //all days of week
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};//setting up array
        System.out.println(weekDays);
        System.out.println("Days of the week:");
        for (int i = 0; i < weekDays.length; i++){
            System.out.println(weekDays[i]);//printing out days of the week in a new line per day
        }
          
        //just weekdays
        System.out.println("\nWeekdays Only:");
        
        String[] temp = new String [5];
        for (int i = 0; i < 5; i++) {
            temp[i] = weekDays[i];
        } //resizing array
        
        for (int i = 0; i < temp.length; i++){
            System.out.println(temp[i]);
        }//priting out new arrary with weekday
        
        
        //shuffling array
        System.out.println("\nShuffled Days of the Week:");
        List<String> weekList = Arrays.asList(weekDays);
		Collections.shuffle(weekList);
		weekList.toArray(weekDays);
                        
        for (int i = 0; i < weekDays.length; i++) {
            System.out.println(weekDays[i]); // printing out shuffled days of the week in a new line per day
        }
    }
    
}
