/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment46;

/**
 *
 * @author mearley2025
 */
public class Assignment46 {

    public static void main(String[] args) {
        final int MAX_ROWS = 10;
        
        System.out.println("a.");
        //for each row
        for (int row = MAX_ROWS; row >= 1; row--) {
            // Print stars
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            // Newline for a new row
            System.out.println();
        }
        
        System.out.println("b.");
        for (int row = MAX_ROWS; row >= 1; row--) {
            //Print spaces
            for (int spaces = 1; spaces <=row; spaces++){
                System.out.print(" ");
            }
            // Print stars
            for (int star = MAX_ROWS; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println("c.");
        for (int row = MAX_ROWS; row>= 1; row--){
            //Print spaces
            for (int spaces = MAX_ROWS; spaces >=row; spaces--){
                System.out.print (" ");
            }
            // Print stars
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
         System.out.println("d.");
         for (int row = 1; row <= 5; row++) {
            // Print spaces
            for (int space = 1; space <= 5 - row; space++) {
                System.out.print(" ");
            }
            // Print stars
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = 5; row >= 1; row--) {
            // Print spaces
            for (int space = 1; space <= 5 - row; space++) {
                System.out.print(" ");
            }
            // Print stars
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("*");
            }
            // Newline for a new row
            System.out.println();
        }
    }
}

