/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mathclass;

/**
 *
 * @author mearley2025
 */
import java.util.Random;
import java.util.Scanner;

public class MathClass {

    public static void main(String[] args) {
         Random generator = new Random();
         int num1 = generator.nextInt(90);
         System.out.println("Number: " + num1);
         System.out.println("Sine: " + (Math.round(Math.sin(num1)*1000.0)/1000.0));
         System.out.println("Cosine: " + (Math.round(Math.cos(num1)*1000.0)/1000.0));
         System.out.println("Tangent: " + (Math.round(Math.tan(num1)*1000.0)/1000.0));
         //question 1, generating a random number as well as the sin, cos, and tan of that number (rounded 3 decimal palces) and dispalying
         
         
         double num2 = generator.nextDouble(1.0,20.0);
         System.out.println("Radius: " + (Math.round(num2)*1000.0)/1000.0);
         System.out.println("Area: " + (Math.round((Math.pow (num2, 2))*Math.PI)*1000.0)/1000.0);
         System.out.println("Volume of Sphere: " + (Math.round((Math.pow (num2, 3))*(4/3)*Math.PI)*1000.0)/1000.0);
         //question 2, generating a random number = radius of a circle, then calcuating the area and volume of a spehere using the radius ALL WITH THREE DECIMAL PLACES
         
         
         double num3 = generator.nextDouble(1000.0,10000000.0);
            num3 = roundAvoid (num3, 5); //roudning the generated number 5 places automatically
            System.out.println("New number: " + num3);
         double numSq = Math.sqrt(num3);
            numSq = roundAvoid(numSq, 5);
            System.out.println("Square root: " + numSq);
        double numLn = Math.log(num3);
            numLn = roundAvoid (numLn, 5);
            System.out.println("Natural log: " + numLn);
        double numLog10 = Math.log10(num3);
            numLog10 = roundAvoid (numLog10, 5);
            System.out.println("Log base 10: " + numLog10);
        //question 3, generating a random numer, fidning the sq root, ln, and log base 10 of the number, and rounding to five dicimal places
        
        
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter number of decimal places of the mass to round to: ");
        int places = scan.nextInt();//setting up an input for number of places to round
        
        double energy =  (299792458^2);
        double mass = (num3/energy);
        mass = roundAvoid (mass, places);
        System.out.println("Mass required to generate " + num3 + " joules of energy: " + mass + " grams");
        //question 4, using random number from question 3 (x), calcuate what mass is requried to generate x joules of energy using e=mc^2
    
        
        System.out.println("Input real number value: ");
            double value = scan.nextDouble();
        System.out.println("Input integer value to put to the power of your number value: ");
            double integer = scan.nextDouble();
        System.out.println("Input place value to round to: ");   
            int round = scan.nextInt();
        
        double answer = Math.pow(value, integer);
             answer = roundAvoid (answer, round);
             System.out.println(value + " to the power of " + integer + " is equal to " + answer);
        //question 5, getting user input of a number and its power, as well as the places to round to     
             
    }
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}

