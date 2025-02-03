/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deckofcards;

/**
 *
 * @author mearley2025
 */

import java.util.*;

public class DeckOfCards {

    public static void main(String[] args) {
        String[][] deckOfCards = new String[4][13];
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};//suit values
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};//number value
        
        int suitsn = suits.length;
        int ranksn = ranks.length;
        //setting size of arary
        
        for (int i = 0; i < suitsn; i++) {//transversing suits arrary
            for (int j = 0; j < ranksn; j++) {//transversing ranks array
                deckOfCards[i][j] = ranks[j] + " of " + suits[i];//putting together suits and ranks array, setting phrasing 
            }
        }
       
        //making 2D deck a 1d array for shuffling
        String[] deck = new String[52];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[index++] = deckOfCards[i][j];
            }
        }

        // Shuffle the deck using method below
        shuffleDeck(deck);

        // Deal 4 hands of 5 cards each uisng method below
        String[][] hands = dealHands(deck);

        // displaying the dif hands using method below
        displayHands(hands);
    }

    // Method to shuffle the deck
    private static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Method to deal 4 hands with 5 cards each
    private static String[][] dealHands(String[] deck) {
        String[][] hands = new String[4][5];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                hands[i][j] = deck[index++];
            }
        }
        return hands;
    }

    // Method to print out the different hands
    private static void displayHands(String[][] hands) {
        char player = 'A';
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand " + player + ": ");
            for (int j = 0; j < hands[i].length; j++) {
                System.out.print(hands[i][j]);
                if (j < hands[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            player++;
        }
    }
}


