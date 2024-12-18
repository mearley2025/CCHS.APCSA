/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unit4test;

/**
 *
 * planning:
 * Within card class:
 * 1. create 2 variables, one for card suit and one for face value
 * 2. Set up options for each value (card: hearts, spades, diamonds, clubs) and face value (1-13)
 * 3. make an array for suit values
 * 4. make a random generator for suit val and face values (+1, starts at 0)
 * 5. check for duplicity
 * 6. print final highest card details
 * 
 * 
 * Within main:
 * 1. make an array list so that it can store cards with no duplicates
 * 2. make something that would "draw" five unique cards and print
 * 3. make something that would read the value of the cards to see highest and print out
 * 4. print out message containing highest card value
 * 
 * @author mearley2025
 */

import java.util.*;//Importing random class and array list to be used


public class Unit4Test {
    public static void main(String[] args) {
        ArrayList<Card> cardList = new ArrayList<>();//setting up array list for all cards
            
         while (cardList.size() < 5) {
            Card newCard = new Card(); // making a new card
            if (!cardList.contains(newCard)) { // make sure it wasn't already drawn
                cardList.add(newCard);
            }
        }
         
        Card highestCard = cardList.get(0); // setting first card as highest, to compare to 4 others
        System.out.println("Cards in Hand:");
        
        for (Card card : cardList) {
            System.out.println(card); // outprint card value
            if (card.getFaceValue() > highestCard.getFaceValue()) {//comparing new card to current "highest" value
                highestCard = card; // updating value based on comparison
            }
        }
        
        System.out.println("\nThe card with the highest value is: " + highestCard);//printing out final message
    }
}

class Card {
    private String suit;// (clubs, diamonds, hearts, spades)
    private int faceValue;//(1-13)

    private static final String[] suits1 = {"Clubs", "Diamonds", "Hearts", "Spades"}; //arry of suit values
    private static final Random random = new Random(); // making random object for face values 

    public Card() {
        this.suit = suits1[random.nextInt(4)]; // choosing random suit from array
        this.faceValue = random.nextInt(13) + 1; // generate random faceValue between 1 and 13
    }

    public int getFaceValue() {
        return faceValue;
    }

    @Override//mkaing sure no cards are the same
    public boolean equals(Object cardC) {
        if (this == cardC) return true; // If same object
        if (cardC == null || getClass() != cardC.getClass()) return false;
        Card card = (Card) cardC;
        return faceValue == card.faceValue && suit.equals(card.suit);
    }

    public String toString() {
        return faceValue + " of " + suit;
    }
    //printing out value of cards and suit to be used in the main
}
