/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment36;

/**
 *
 * @author mearley2025
 */
import java.util.Scanner;//used in quesiton 2
public class Assignment36 {

    public static void main(String[] args) {
       //question 1a.
        enum DaysofW {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday} //creates enum with variables
       DaysofW day1, day2, day3, day4, day5, day6, day7;
       day1 = DaysofW.Monday;
       day2 = DaysofW.Tuesday;
       day3 = DaysofW.Wednesday;
       day4 = DaysofW.Thursday;
       day5 = DaysofW.Friday;
       day6 = DaysofW.Saturday;
       day7 = DaysofW.Sunday;
       //making varables with the enum values
       
       System.out.println("Day 1 value: " + day1);
       System.out.println(day1 + " day number: " + (day1.ordinal()+1)); // printing out the enum values with ordinal, but adding 1 to ordinal so that it prints out the days in the week (1-7).
       System.out.println("Day 2 value: " + day2);
       System.out.println(day2 + " day number: " + (day2.ordinal()+1));
       System.out.println("Day 3 value: " + day3);
       System.out.println(day3 + " day number: " + (day3.ordinal()+1));
       System.out.println("Day 4 value: " + day4);
       System.out.println(day4 + " day number: " + (day4.ordinal()+1));
       System.out.println("Day 5 value: " + day5);
       System.out.println(day5 + " day number: " + (day5.ordinal()+1));
       System.out.println("Day 6 value: " + day6);
       System.out.println(day6 + " day number: " + (day6.ordinal()+1));
       System.out.println("Day 7 value: " + day7);
       System.out.println(day7 + " day number: " + (day7.ordinal()+1));
       
       
       //question 1b.
       enum Monthsofy {January, Febuary, March, April, May, June, July, August, September, October, November, December}; //enum with months of the year
       Monthsofy m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12;
       m1 = Monthsofy.January;
       m2 = Monthsofy.Febuary;
       m3 = Monthsofy.March;
       m4 = Monthsofy.April;
       m5 = Monthsofy.May;
       m6 = Monthsofy.June;
       m7 = Monthsofy.July;
       m8 = Monthsofy.August;
       m9 = Monthsofy.September;
       m10 = Monthsofy.October;
       m11 = Monthsofy.November;
       m12 = Monthsofy.December;
       //making varables with the enum values
       
       System.out.println();
       System.out.println("Month " + (m1.ordinal()+1) + " value: " + m1); //prinitng out enum and ordinal number plus one so that it is months in year (1-12).
       System.out.println("Month " + (m2.ordinal()+1) + " value: " + m2);
       System.out.println("Month " + (m3.ordinal()+1) + " value: " + m3);
       System.out.println("Month " + (m4.ordinal()+1) + " value: " + m4);
       System.out.println("Month " + (m5.ordinal()+1) + " value: " + m5);
       System.out.println("Month " + (m6.ordinal()+1) + " value: " + m6);
       System.out.println("Month " + (m7.ordinal()+1) + " value: " + m7);
       System.out.println("Month " + (m8.ordinal()+1) + " value: " + m8); 
       System.out.println("Month " + (m9.ordinal()+1) + " value: " + m9);
       System.out.println("Month " + (m10.ordinal()+1) + " value: " + m10);
       System.out.println("Month " + (m11.ordinal()+1) + " value: " + m11);
       System.out.println("Month " + (m12.ordinal()+1) + " value: " + m12); 
       //printing the ordinal with the month instead of the previous formatting to make it less redundant
       
       
       //question 2
        Scanner scan = new Scanner (System.in);
        System.out.println();
        System.out.println("CCHS username with name and graduation year: ");
        String username = scan.nextLine(); //setting up string
        String gradYear = username.substring(username.length() - 4); // obtaining grad year from string
        int year = Integer.parseInt(gradYear);//converting string that is your grad year into an integer
        System.out.println("Your graduation year is: " + gradYear);//printing out grad year
        int nextYear = year + 1;
        System.out.println(nextYear + " is the year after you graduate");//priting out the year after you graduate
        System.out.println("In computer language, you graduate in: " +  Integer.toBinaryString(year));//printing out grad year in binary
    } 
}
