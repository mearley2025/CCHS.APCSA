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
to add complexity/show learned skills, output the final closing message using a seperate class that has 3 differnt messages based on gramatical correctness
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

        //Closing message using a class
        int rounds = youWin + computerWin + ties;//calcuating number of rounds
        youWonMessage win = new youWonMessage ();
            win.setRounds1(rounds);
            win.setyouWin1(youWin);
        System.out.println(win);
        scanner.close(); // Close the scanner
    }
}

class youWonMessage{
        private int rounds1 = 0;
        private int youWin1 = 0;
        
        
        
    public void setRounds1 (int inrounds1){
        rounds1 = inrounds1;//setting round number equal to what is in the main
    }
    public void setyouWin1 (int inyouWin1){
        youWin1 = inyouWin1;//setting wins equal to what is in the main
    }
    
    public String toString(){
        String result = ""; //returns the state of the object (class) as a string
        if (youWin1 == 1){
            result = "\nThank you for playing. You won " + youWin1 + " time out of " + rounds1 + " rounds";//fixing grammar if you only 1 one round
        }else if (rounds1 == 1){
                  result = "\nThank you for playing. You won " + youWin1 + " times out of " + rounds1 + " round";//fixing grammar if you played one round
        }else if (youWin1 == 1 && rounds1 == 1){
                         result = "\nThank you for playing. You won " + youWin1 + " time out of " + rounds1 + " round";//fixing grammar if you played and won one round
        } else {
            result = "\nThank you for playing. You won " + youWin1 + " times out of " + rounds1 + " rounds";//regular closing message
        }        
        return result; //formatting the string that will be returned/printed
    }
}
