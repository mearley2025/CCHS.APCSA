/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystore;

/**
 *
 * @author mearley2025
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class MyStore {
    private static final double MAX_BUDGET = 250.00; //setting constant variable, maximum budget amount
     
    public static void main(String[] args) {
        // Create an array of all possible Item objects and their price
        Item[] items = {
            new Item("T Shirt", 29.99),
            new Item("Shoes", 125.99),
            new Item("Jeans", 60.99),
            new Item("Jacket", 250.00),
            new Item("Hat", 25.99),
            new Item("Shorts", 75.99),
            new Item("Blouse", 88.99)
        };

        // Initialize scanner and number formatter
        Scanner scanner = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        
        // Variables to keep track of total cost and item count
        double totalCost = 0;
        int itemCount = 0;

        while (true) {
            // Ask user input of an item
            System.out.println("Enter an item name (or 'none' to end program): ");
            String input = scanner.nextLine().trim();

            // If user types "none", stop the loop
            if (input.equalsIgnoreCase("none")) {
                break;
            }

            // Look for the item in the store
            boolean itemFound = false;
            for (Item item : items) {
                if (item.getStrName().equalsIgnoreCase(input)) {
                    itemFound = true;
                    // checking item's cost with allocated budget
                    if (totalCost + item.getDblPrice() <= MAX_BUDGET) {
                        totalCost += item.getDblPrice();
                        itemCount++;
                        System.out.println(item);
                        System.out.println("Total items purchased: " + itemCount + "\nTotal spent: " + formatter.format(totalCost));
                    } else {
                        System.out.println("WARNING: You will exceeded your budget of $250 if you buy this item!");
                    }
                    break;
                }
            }

            // If the item doesn't exist in the store
            if (!itemFound) {
                System.out.println("Item not found, please enter a different item.");
            }
        }
        // Final message, after user types in "end"
        System.out.println("You bought " + itemCount + " items. Total money spent: " + formatter.format(totalCost));
    }
}

class Item {
    //creating item class variables
    private String strName;
    private double dblPrice;
    
    //constructor that initialises items
    public Item(String strName, double dblPrice){
        this.strName = strName;
        this.dblPrice = dblPrice;
    }
    
    //getters
    public String getStrName(){
        return strName;
    }
    public double getDblPrice(){
        return dblPrice;
    }
    
    //setters
    public void setStrName(String strName) {
        this.strName = strName;
    }
    public void setDblPrice(double dblPrice){
        this.dblPrice = dblPrice;
    }
    
    //to string method that formats result as a string
    @Override
    public String toString() {
        return "Item Added: " + strName + "\nPrice: " + dblPrice;
    }
   
}