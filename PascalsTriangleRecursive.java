/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pascalstrianglerecursive;

/**
 *
 * @author mearley2025
 */
import java.util.Scanner;
public class PascalsTriangleRecursive {    
    
// recursive function for calcualtions 
    public static int getPascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }
        return getPascalValue(row - 1, col - 1) + getPascalValue(row - 1, col);
    }
    
    // return row using an array
    public static int[] getNthRow(int n) {
        int[] rowValues = new int[n + 1]; // array 
        for (int i = 0; i <= n; i++) {
            rowValues[i] = getPascalValue(n, i); // claculate and store values
        }
        return rowValues;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the row number (N) of Pascal's Triangle: ");
        int n = scanner.nextInt();
        scanner.close();
        
        int[] nthRow = getNthRow(n);
        
        System.out.println("The " + n + "th row of Pascal's Triangle is:");
        for (int num : nthRow) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
