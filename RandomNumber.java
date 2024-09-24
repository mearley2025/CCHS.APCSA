/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomnumber;

/**
 *
 * @author mearley2025
 */
import java.util.Random;       
public class RandomNumber {

    public static void main(String[] args) {
        //Part 1 - Phone Number Generator
        Random generator = new Random();
        
        System.out.println("Random Phone Number Generated:");
        int num1 = generator.nextInt(7);
        int num2 = generator.nextInt(7);
        int num3 = generator.nextInt(7);
        
        int numString1 = generator.nextInt(100,655);
        int numString2 = generator.nextInt(100,999);
        
  
        //if (numString1<10){
          //  System.out.println(num1 + "" + num2 + "" + num3 + "-00" + numString1 + "-" + numString2);
       // } else if (numString1<100){
      //      System.out.println(num1 + "" + num2 + "" + num3 + "-0" + numString1 + "-" + numString2); 
      //  }else{
            System.out.println(num1 + "" + num2 + "" + num3 + "-" + numString1 + "-" + numString2);
      //  }
        //The blocked out part above is when I tried to add a 0 to the 2nd number if it had less than 3 digits, but that was before I realised that you could just limit the number range
      
        //Part 2 - 6 sided Die generator
        
        System.out.println("Random Die Number Generated:");
        int dieNum = generator.nextInt(1,6);
        System.out.println(dieNum);
            
    }
}
