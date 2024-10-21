/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment38;

/**
 *
 * @author mearley2025
 */

/*
Math Planning:
trying to output how much you need to pay each month along with total amount paid (so far) and amounnt needed to pay back (what is left)

using the eq: 
monthy payment = [loan amount * interest(1+interest)^number of months]/[(1+interest)^number of months -1]
*/

import java.util.Scanner;
import java.text.NumberFormat;
public class Assignment38 {

    public static void main(String[] args) {
        InterestRateCalculator dollars = new InterestRateCalculator(); //creating new object
        System.out.println("Input Financial Amount: ");
        Scanner scan = new Scanner (System.in);
        double amount = scan.nextDouble();//asking for user input of amount
        
        System.out.println("Months?");
        Scanner scan2 = new Scanner (System.in);
        double months = scan2.nextDouble();//asking for number of months
       
        dollars.setMoney(amount);
        dollars.setMonths(months);
        
        System.out.println(dollars);
        
    }
}

class InterestRateCalculator {
    public final double RATE = .10;//10%
    private double inputAmount = 0;
    private double inputMonths = 0;

    public void setMoney (double inMoney){
        inputAmount = inMoney;
    }
    public void setMonths (double inMonths){
        inputMonths = inMonths;
    }
    
    
    
    public String toString(){
            String results = ""; //returns the state of the object (class) as a string
            results = "input amount check:" + inputAmount + "\n" +
                    "months check:" + inputMonths;
            return results;
    }
}