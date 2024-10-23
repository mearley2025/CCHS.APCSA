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
        
        System.out.println("this is the amount of months: "+dollars.getPay());
        
    }
}

class InterestRateCalculator {
    public final double RATE = .035;//3.5%
    private double inputAmount;
    private double inputMonths;
    private double remainAmount;
    private double remainMonths;
    private double toPay;

    public void setMoney (double inMoney){
        inputAmount = inMoney;//setting inital number equal to user input
    }
    public void setMonths (double inMonths){
        inputMonths = inMonths;//setting months equal to user input
    }
    
    
    public void theMath(){
        toPay = (remainAmount*RATE+remainAmount)/inputMonths;
        
        remainAmount = inputAmount-toPay;
        inputMonths = inputMonths-1;
    }
    public double getPay(){
        return toPay;
    }
    public double getMonths(){
        return inputMonths;
    }
}
