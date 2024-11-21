/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppinglist;

/**
 *
 * @author mearley2025
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ShoppingList {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        ArrayList<String> newList = new ArrayList<>();//new array lsit
        
        //setting up inital iput for items
        System.out.println("Enter in shopping list items (type 'none' if entered all items):");
        while (true){
            String item = scan.nextLine();
            if (item.equalsIgnoreCase("none")){
                break;//closes out user input of items
            }
            newList.add(item);
        }
        displayList(newList);//printing out initial list
        
        //setting up user defined items to remove
        System.out.println("Enter the number of the item to remove or type in 'none' if finished");
        while (true){
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("none")){
                break;//closes out use input of items to remove
            }
        
        //removing specified items from list
            try {
                int indexToRemove = Integer.parseInt(input) - 1; // Convert to zero-based index
                if (indexToRemove >= 0 && indexToRemove < newList.size()) {
                    System.out.println("Removing: " + newList.get(indexToRemove));
                    newList.remove(indexToRemove);
                } else {
                    System.out.println("Item number doesn't exist, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter item number to remove.");
            }
        }
        
      //printing out final list after adding/removing items
        System.out.println("Final shopping list:");
        displayList(newList);
    }
    
    //formatting list output (what you see)
    private static void displayList(ArrayList<String> list){
        System.out.println("Your shopping list:");
        for (int i = 0; i <list.size(); i++){
            System.out.println((i+1) + ": " + list.get(i));
        }
    }
}