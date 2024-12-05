package com.mycompany.sm1finalgame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*Game Planning:
Rock, Paper, Scissors game agaist computer (random generator)
Will need to have user input, read that input, and compare it agaist random generator
have limitations so that if the user inputs something other than rock, paper, and scissors it outputs an error
make the game playable more than once (ask user yes/no and limit that so that it will output error if something else is entered)
track the amount of times you win versus the computer on the screen (score) to be displayed after every turn
end the game if no is typed when prompted, and display final message of wins and number of rounds played 
*/



import java.util.Scanner; // allows user input
import java.util.Random;  // allows computer to use random number generator

public class Sm1FinalGame {
    public static void main(String[] args) {
        
        // variables to be used for the score keeping
        int youWin = 0;
        int computerWin = 0;
        int ties = 0;

        // Create Scanner and Random objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean keepPlaying = true;//loops the game
        while (keepPlaying) {//main code for game inside 
            System.out.println("\nType in your choice (rock, paper, scissors): ");//asking for user input
            String userChoice = scanner.nextLine().toLowerCase(); // converts to lowercase, in case they type in "Rock, Paper, or Scissors"

            // Preventing other inputs
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input, please try again. Enter rock, paper, or scissors.");
                continue; // Restart the loop if input is invalid
            }

            // Computer's choice 
            int computerChoiceNum = random.nextInt(3); // Generate a random number (0, 1, or 2)
            String computerChoice = ""; // Initialize computer choice
            switch (computerChoiceNum) {
                case 0:
                    computerChoice = "rock";
                    break;
                case 1:
                    computerChoice = "paper";
                    break;
                case 2:
                    computerChoice = "scissors";
                    break;
            }

            // Output both user input and computer choice
            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
                ties++;//setting up for score tally
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                       (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                       (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
                youWin++;
            } else {
                System.out.println("Computer wins!");
                computerWin++;
            }

            // Display the new score
            System.out.println("\nScore:");
            System.out.println("You: " + youWin);
            System.out.println("Computer: " + computerWin);
            System.out.println("Ties: " + ties);

            // Ask the user if they want to play again
            boolean stopPlaying = true;
            System.out.println("\nDo you want to play again? (yes/no): ");
            while (stopPlaying) {
                String playAgain = scanner.nextLine().toLowerCase();
                if (playAgain.equals("no")) {
                    keepPlaying = false; // Exit the loop if input is no/No/NO
                    stopPlaying = false;
                }
                if (!playAgain.equals("yes")&& !playAgain.equals("no")){
                    System.out.println("Invalid input, please try again. Enter yes or no");
                    continue;
                }
                if (playAgain.equals("yes")){
                    stopPlaying = false;
                    keepPlaying = true;
                    continue;
                    }
            }
        }

        //Closing message
        int rounds = youWin + computerWin + ties;//calcuating number of rounds
        System.out.println("\nThank you for playing. You won: "+ youWin + " times out of " + rounds + " rounds");
        scanner.close(); // Close the scanner
    }
}
