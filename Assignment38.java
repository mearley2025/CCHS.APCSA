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
trying to output how much you need to pay each month with interest along with total amount paid (so far) and amounnt needed to pay back (what is left)
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
        
        for(int i = (int) dollars.getMonths(); i > 0; i--){
           double payment = dollars.theMath(); // mkaing a variable equal to payment needed based on month
           System.out.println("\n Monthy Payment: " + currency.format(payment));
           System.out.println("Amount left: " + currency.format(dollars.getPay()));
           System.out.println("Amount paid so far: " + currency.format(dollars.getTotalPaid()) + "\n"); 
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
        double monthlyInterest = (inputAmount * RATE) / 12; // calculating monthly interest
        double principalPayment = inputAmount / inputMonths; // calculating principal part of the payment
        double totalPayment = monthlyInterest + principalPayment; // total payment is interest + principal

        inputAmount -= principalPayment; // reduce the remaining balance by principal only
        totalPaid += totalPayment; // updating total paid by adding the total payment
        inputMonths--; // updating remaining months

        return totalPayment;
    }
    
    public double getPay(){
        return inputAmount;
    }
    public double getTotalPaid(){
        return totalPaid;
    }
    public double getMonths(){
        return inputMonths;
    }
}
