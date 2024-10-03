/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment35;

/**
 *
 * @author mearley2025
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Assignment35 {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Total number of students: ");
            double total = scan.nextInt();
        System.out.println("Number of girls: ");
            double girls = scan.nextInt();
        double gpercent = (girls/total);
        double bpercent = ((total-girls)/total);
            
        NumberFormat fmt1 = NumberFormat.getPercentInstance();
        System.out.println("Precent of girls " + fmt1.format(gpercent));
        System.out.println("Precent of boys " + fmt1.format(bpercent));
        //Questions 1, precentage of boys and girls in a school via user input
        
        
        System.out.println("Enter monetary amount: ");
        double amount = scan.nextDouble();
        double exchangeRate = 0.76;
        double inpounds = amount*exchangeRate; // converting to pounds
        NumberFormat fm2 = NumberFormat.getCurrencyInstance(Locale.UK); //formatting amount in pounds
        NumberFormat fm3 = NumberFormat.getCurrencyInstance(Locale.US); //formatting amount in dollars
        System.out.println(fm3.format(amount) + "in pounds is " + fm2.format(inpounds) + " with a " + exchangeRate + " exchange rate");
        //Question 2, converting user amount from dollars to pounds
        
        
        System.out.println("Enter integer from 0-15: ");
        int places = scan.nextInt();
        double roundto = Math.pow(10, places);
        double fnum = Math.round(Math.PI*roundto)/roundto;
        System.out.println("Pi rounded to " + places + " places equals " + fnum);
        //Question 3, rounding pi to the decimal place of user input
        
        
        Random generator = new Random();
        int number = generator.nextInt(100000000, (int) (999*Math.pow(10, 18)));
        System.out.println("Random Number: " + number);
        //Question 4, generating a random number between a 10,000,000 and 999e18, outputting without scientific notation
    }
}
