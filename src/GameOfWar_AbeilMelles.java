// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//game of war
//played with one deck of 52 cards
//create card class with faceVal and suit and color
// create deck object
    // ArrayList<card>
    // write methods: shuffle, dealTheDeck
// player class with at least two attributes, name and arraylist
    // write methods: getName, takeTurn

import java.util.Scanner;

//make the game class (driver, tester) Main
    //makes a unique deck with 52 cards
    //makes two players
    //
public class GameOfWar_AbeilMelles {



    public static void playGame(Player playerOne, Player playerTwo, Deck deck) {
        deck.deal(playerOne,playerTwo);
        int round = 1;
        boolean entire = false;
        while (playerOne.getHand().size() > 0 && playerTwo.getHand().size() > 0 && !entire) {  //while both sizes are greater than zero, and the user hasn't inputed "entire"
            Scanner scan = new Scanner(System.in);
            System.out.println("\n" + "Round " + round);
            System.out.println("Would you like to simulate 1 round, 10 rounds, or the entire thing");
            if (round == 1) {
                System.out.println("Enter 'one' for 1, 'ten' for 10, 'entire' for entire.");
            }
            String nextInput = scan.next();
            if(nextInput.equals("one")) { //simulate one round
                playerOne.takeTurn(playerTwo);
                System.out.print("PlayerOne Hand Size: " + playerOne.getHand().size());
                System.out.println(" ||" + " PlayerTwo Hand Size: " + playerTwo.getHand().size());
                round++;
            } else if (nextInput.equals("ten")) {
                int i = 0;
                while (i < 10 && playerOne.getHand().size() > 0 && playerTwo.getHand().size() > 0) { //simulate ten rounds
                    playerOne.takeTurn(playerTwo);
                    round++;
                    i++;
                }
                System.out.print("PlayerOne Hand Size: " + playerOne.getHand().size() + " || ");
                System.out.print("PlayerTwo Hand Size: " + playerTwo.getHand().size() + "\n");
            } else if (nextInput.equals("entire")){ //simulate entire thing from current round, entire = true
                entire = true;
                while (playerOne.getHand().size() > 0 && playerTwo.getHand().size() > 0) {
                    System.out.println("Round: " + round);
                    playerOne.takeTurn(playerTwo);
                    round++;
                }
            }
        }
        System.out.println("Round: " + round);
        if (playerOne.getHand().size() > playerTwo.getHand().size()) {;
            System.out.println("Player 1 is the winner!");
        } else {
            System.out.println("Player 2 is the winner!");
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck(deck);
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to the Game of War\n\nEnter Player One Name here: ");
        Player playerOne = new Player(scan.next(), deck);
        System.out.print("\nEnter Player Two name here: ");
        Player playerTwo = new Player(scan.next(), deck);

        playGame(playerOne,playerTwo,deck);

    }





//    public static int loanRepay(int n, int initialAmt, int month, double interest) {
//        if (n == 0) {
//            return initialAmt;
//        } else {
//            return (int) (loanRepay(n-1, initialAmt, month, interest) - month + interest
//                    * loanRepay(n-1, initialAmt, month, interest));
//        }
//    }
}