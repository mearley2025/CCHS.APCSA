/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment38;

/**
 *
 * @author mearley2025
 */

/*
Requirements:
1. user defined input of money and months
2. output amount needed to pay per month with interest
3. output amount you still need to pay
4. output amount you have already paid
*/

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Assignment38 {

    public static void main(String[] args) {
        InterestRateCalculator dollars = new InterestRateCalculator(); //creating new object
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);//creating method to use

        //user input section
        System.out.println("Input Financial Amount: ");
        Scanner scan = new Scanner (System.in);
        double amount = scan.nextDouble();//setting input to finacial amount
        System.out.println("Months?");
        double months = scan.nextDouble();//setting input to number of months
       
        dollars.setMoney(amount);//giving object-specific values to be used by the class
        dollars.setMonths(months);
        
        for(int i = (int) dollars.getMonths(); i > 0; i--){//limits the program so that it stops when months run out, (no negative months)
           double payment = dollars.theMath(); // making a variable equal to payment needed based on month, allows for easier acess beow
           //printing out information
           if(i!=1){//applies to all months but the last
            System.out.println("\nMonthy Payment: " + currency.format(payment));
            System.out.println("Interest paid: " + currency.format(dollars.getinterestPaid()));
            System.out.println("Amount left: " + currency.format(dollars.getPay()));
            System.out.println("Amount paid so far: " + currency.format(dollars.getTotalPaid()) + "\n"); 
           }else{//last month
            System.out.println("\nMonthy Payment: " + currency.format(payment));
            System.out.println("Amount left: $0.0");//gets rid of the negative number resluting from extra cash needed to pay due to interest, only occurs on last month
            System.out.println("Amount paid so far: " + currency.format(dollars.getTotalPaid()) + "\n");
           }
           
       }  
    }
}

class InterestRateCalculator {
    public final double RATE = .1;//10%
    private double inputAmount;
    private double inputMonths;
    private double totalPaid = 0;

    public void setMoney (double inMoney){
        inputAmount = inMoney;//setting inital number equal to user input
    }
    public void setMonths (double inMonths){
        inputMonths = inMonths;//setting months equal to user input
    }
    
    
    public double theMath(){
        double payment = (inputAmount * RATE + inputAmount) / inputMonths;
        inputAmount -= payment; // updating input amount by subtracting what you just payed
        totalPaid += payment; // updating total paid by adding what you just paid
        inputMonths--; // updating remaning month by subtracting one
        return payment;//returning value of math above, what you need to pay (varies per month)
    }
    //additional values to be used
    public double getPay(){
        return inputAmount;
    }
    public double getTotalPaid(){
        return totalPaid;
    }
    public double getMonths(){
        return inputMonths;
    }
    //additional feature, outputting what you are paying for interest
    public double getinterestPaid(){
        double iPayment = (inputAmount*RATE);
        return iPayment;
    }
}