import java.util.ArrayList;

public class Player {

    private final String name;

    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name, Deck deck) {
        this.name = name;
        deck = deck;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    ////for all instances I used a placeholder array to store the vals of both the winner and loser of the round, and then
    //// just added the placeholder array to the end of the winner's arraylist.
    ////Instead of initializing each time, I could have maybe initialized it as a private instance variable and then just referred to
    ////it as placeholder, and gave it new vals.
    ////Also could have made individual methods for each of the for loop parts, because they stay the same for the most part
    public void takeTurn(Player playerTwo) {
        if (hand.get(0).getValue() == playerTwo.hand.get(0).getValue()) { // if both first vals are equal to each other
            if (hand.size() >= 5 && playerTwo.hand.size() >= 5) {   // if both sizes are greater than 5
                if (hand.get(4).getValue() == playerTwo.hand.get(4).getValue()) { // if 4th card vals are equal to each other
                    if (hand.get(5).getValue() > playerTwo.hand.get(5).getValue()) { // if hand's 5th card val is > than playerTwo's hand's 5th val
                        ArrayList<Card> placeHolder = new ArrayList<>();
                        int second = 0;
                        for (int i = 0; i < 5; i++) {
                            placeHolder.add(hand.get(i));
                            placeHolder.add((playerTwo.hand.get(second)));
                            second++;
                        }
                        for (int i = 0; i < 4; i++) {
                            hand.remove(0);
                            playerTwo.hand.remove(0);
                        }
                        hand.addAll(placeHolder);
                    } else if (hand.get(5).getValue() < playerTwo.hand.get(5).getValue()) { // opposite of previous comment
                        ArrayList<Card> placeHolder = new ArrayList<>();
                        int second = 0;
                        for (int i = 0; i < 5; i++) {
                            placeHolder.add(hand.get(i));
                            placeHolder.add((playerTwo.hand.get(second)));
                            second++;
                        }
                        for (int i = 0; i < 4; i++) {
                            hand.remove(0);
                            playerTwo.hand.remove(0);
                        }
                        playerTwo.hand.addAll(placeHolder);
                    } else if (hand.get(5).getValue() == playerTwo.hand.get(5).getValue()) {
                        if (hand.get(5).getColor().equals("Red") && !playerTwo.hand.get(5).getColor().equals("Red")) { // Tiebreaker, whichever card color is Red wins
                            ArrayList<Card> placeHolder = new ArrayList<>();
                            int second = 0;
                            for (int i = 0; i < 5; i++) {
                                placeHolder.add(hand.get(i));
                                placeHolder.add((playerTwo.hand.get(second)));
                                second++;
                            }
                            for (int i = 0; i < 4; i++) {
                                hand.remove(0);
                                playerTwo.hand.remove(0);
                            }
                            hand.addAll(placeHolder);
                        } else if (playerTwo.hand.get(5).getColor().equals("Red") && !hand.get(5).getColor().equals("Red")) { //same as previous comment
                            ArrayList<Card> placeHolder = new ArrayList<>();
                            int second = 0;
                            for (int i = 0; i < 5; i++) {
                                placeHolder.add(hand.get(i));
                                placeHolder.add((playerTwo.hand.get(second)));
                                second++;
                            }
                            for (int i = 0; i < 4; i++) {
                                hand.remove(0);
                                playerTwo.hand.remove(0);
                            }
                            playerTwo.hand.addAll(placeHolder);
                        } else if (playerTwo.hand.get(5).getColor().equals("Red") && hand.get(5).getColor().equals("Red")) { // if both cards are red
                            if (playerTwo.hand.get(5).getSuit().equals("Heart")) { // Heart always wins //Tiebreaker
                                ArrayList<Card> placeHolder = new ArrayList<>();
                                int second = 0;
                                for (int i = 0; i < 5; i++) {
                                    placeHolder.add(hand.get(i));
                                    placeHolder.add((playerTwo.hand.get(second)));
                                    second++;
                                }
                                for (int i = 0; i < 4; i++) {
                                    hand.remove(0);
                                    playerTwo.hand.remove(0);
                                }
                                playerTwo.hand.addAll(placeHolder);
                            } else if (hand.get(5).getSuit().equals("Heart")) { // same as previous comment
                                ArrayList<Card> placeHolder = new ArrayList<>();
                                int second = 0;
                                for (int i = 0; i < 5; i++) {
                                    placeHolder.add(hand.get(i));
                                    placeHolder.add((playerTwo.hand.get(second)));
                                    second++;
                                }
                                for (int i = 0; i < 4; i++) {
                                    hand.remove(0);
                                    playerTwo.hand.remove(0);
                                }
                                hand.addAll(placeHolder);
                            }
                        }
                    }

                } else if (hand.get(4).getValue() > playerTwo.hand.get(4).getValue()) {   //if the val at 4 in hand is greater than playerTwo hand at 4
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    int second = 0;
                    for (int i = 0; i < 4; i++) {
                        placeHolder.add(hand.get(i));
                        placeHolder.add(playerTwo.hand.get(second));
                        second++;
                    }
                    for (int i = 0; i < 4; i++) {
                        hand.remove(0);
                        playerTwo.hand.remove(0);
                    }
                    hand.addAll(placeHolder);
                } else if (hand.get(4).getValue() < playerTwo.hand.get(4).getValue()) {  //if the val at 4 in playerTwo hand is greater than hand at 4
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    int second = 0;
                    for (int i = 0; i < 4; i++) {
                        placeHolder.add(hand.get(i));
                        placeHolder.add(playerTwo.hand.get(second));
                        second++;
                    }
                    for (int i = 0; i < 4; i++) {
                        hand.remove(0);
                        playerTwo.hand.remove(0);
                        //i--;
                    }
                    playerTwo.hand.addAll(placeHolder);
                }
            } else if (hand.size() < 5 && playerTwo.hand.size() < 5) {  // if both sizes are lower than 5
                if (hand.get(hand.size() - 1).getValue() > playerTwo.hand.get(playerTwo.hand.size() - 1).getValue()) { //if hand at last val is greater than playerTwo hand at last val
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    placeHolder.addAll(hand);
                    placeHolder.addAll(playerTwo.hand);
                    playerTwo.hand.clear();

                } else if (hand.get(hand.size()-1).getValue() < playerTwo.hand.get(playerTwo.hand.size()-1).getValue()) { //if playerTwo at last val is greater than hand at last val
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    placeHolder.addAll(hand);
                    placeHolder.addAll(playerTwo.hand);
                    hand.clear();

                }
            } else if (hand.size() < 5) { // if just hand size is lower than 5
                if (hand.get(hand.size()-1).getValue() > playerTwo.hand.get(4).getValue()) { // if last val in hand is greater than playerTwo hand val at 4
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    placeHolder.addAll(hand);
                    for (int i = 0; i < 4; i++) {
                        placeHolder.add(playerTwo.hand.get(i));
                    }
                    hand.clear();
                    playerTwo.hand.subList(0, 4).clear();
                    hand.addAll(placeHolder);

                } else if (hand.get(hand.size()-1).getValue() < playerTwo.hand.get(4).getValue()) { // opposite of previous comment
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    placeHolder.addAll(hand);
                    placeHolder.addAll(playerTwo.hand);
                    hand.clear();

                }
            } else if (playerTwo.hand.size() < 5) { // if playerTwo hand size is lower than 5
                if (hand.get(4).getValue() > playerTwo.hand.get(playerTwo.hand.size() - 1).getValue()) { //if last val in playerTwo hand is less than hand val at 4
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    placeHolder.addAll(hand);
                    placeHolder.addAll(playerTwo.hand);
                    playerTwo.hand.clear();

                } else if (hand.get(4).getValue() < playerTwo.hand.get(playerTwo.hand.size()-1).getValue()) { // opposite of previous comment
                    ArrayList<Card> placeHolder = new ArrayList<>();
                    placeHolder.addAll(hand);
                    placeHolder.addAll(playerTwo.hand);
                    hand.clear();

                }
            }
        } else if (hand.get(0).getValue() > playerTwo.hand.get(0).getValue()) { //if first hand val is greater than playerTwo hand first val
            hand.add(hand.get(0));
            hand.add(playerTwo.hand.get(0));
            hand.remove(0);
            playerTwo.hand.remove(0);
        } else if (hand.get(0).getValue() < playerTwo.hand.get(0).getValue()) { //opposite of previous comment
            playerTwo.hand.add(playerTwo.hand.get(0));
            playerTwo.hand.add(hand.get(0));
            playerTwo.hand.remove(0);
            hand.remove(0);
        }
    }

    public static void main(String[] args) {}

}

//if (hand.get(hand.size() - 1) == playerTwo.hand.get(hand.size() - 1)) {
//        if (hand.size() >= 5 && playerTwo.hand.size() >= 5) {
//            if (hand.get(hand.size() - 5).getValue() > playerTwo.hand.get(hand.size() - 5).getValue()) {
//
//            }
//        }
//
//    }

    //int remove = 0;
//                  for (int i = 0; i < 8; i++) {
//                      if (i < 4) {
//                          placeHolder.add(hand.get(i));
//                          hand.remove(remove);
//                      } else {
//                          placeHolder.add(playerTwo.hand.get(i));
//                          playerTwo.hand.remove(remove);
//                      }
//                      //i--;
//                  }
//                    ArrayList<Card> placeHolder = new ArrayList<>();
//                    for (int i = 0; i < hand.size(); i++) {
//                        if (i < playerTwo.hand.size()) {
//                            placeHolder.add(hand.get(i));
//                            hand.remove(i);
//                        }
//                        placeHolder.add(playerTwo.hand.get(i));
//                        playerTwo.hand.remove(i);
//                        i--;
//                    }
//                    playerTwo.hand.addAll(placeHolder);
//                    ArrayList<Card> placeHolder = new ArrayList<>();
//                    for (int i = 0; i < hand.size(); i++) {
//                        if (i < playerTwo.hand.size()) {
//                            placeHolder.add(hand.get(i));
//                            hand.remove(i);
//                        }
//                        placeHolder.add(playerTwo.hand.get(i));
//                        playerTwo.hand.remove(i);
//                        i--;
//                    }
//                    hand.addAll(placeHolder);
//                    ArrayList<Card> placeHolder = new ArrayList<>();
//                    for (int i = 0; i < hand.size(); i++) {
//                        if (i < playerTwo.hand.size()) {
//                            placeHolder.add(hand.get(i));
//                            hand.remove(i);
//                        }
//                        placeHolder.add(playerTwo.hand.get(i));
//                        playerTwo.hand.remove(i);
//                        i--;
//                    }
//                    playerTwo.hand.addAll(placeHolder);
//                    for (int i = 0; i < hand.size(); i++) {
//                        if (i < playerTwo.hand.size()) {
//                            placeHolder.add(hand.get(i));
//                            hand.remove(i);
//                        }
//                        placeHolder.add(playerTwo.hand.get(i));
//                        playerTwo.hand.remove(i);
//                        i--;
//                    }
//                    hand.addAll(placeHolder);
//                    if (hand.size() > playerTwo.hand.size()) {  // checks to see which array is longer so we can iterate
//                        for (int i = 0; i < hand.size(); i++) {
//                            if (i < playerTwo.hand.size()) {
//                                placeHolder.add(playerTwo.hand.get(i));
//                                playerTwo.hand.remove(i);
//                            }
//                            placeHolder.add(hand.get(i));
//                            hand.remove(i);
//                            i--;
//                        }
//                    } else if (hand.size() < playerTwo.hand.size()) { //same as comment above
//                        for (int i = 0; i < hand.size(); i++) {
//                            if (i < playerTwo.hand.size()) {
//                                placeHolder.add(hand.get(i));
//                                hand.remove(i);
//                            }
//                            placeHolder.add(playerTwo.hand.get(i));
//                            playerTwo.hand.remove(i);
//                            i--;
//                        }
//                        playerTwo.hand.addAll(placeHolder);
//                    }
//                    if (hand.size() > playerTwo.hand.size()) {  // checks to see which array is longer so we can iterate
//                        for (int i = 0; i < hand.size(); i++) {
//                            if (i < playerTwo.hand.size()) {
//                                placeHolder.add(playerTwo.hand.get(i));
//                                playerTwo.hand.remove(i);
//                            }
//                            placeHolder.add(hand.get(i));
//                            hand.remove(i);
//                            i--;
//                        }
//                    } else if (hand.size() < playerTwo.hand.size()) { //same as comment above
//                        for (int i = 0; i < hand.size(); i++) {
//                            if (i < playerTwo.hand.size()) {
//                                placeHolder.add(hand.get(i));
//                                hand.remove(i);
//                            }
//                            placeHolder.add(playerTwo.hand.get(i));
//                            playerTwo.hand.remove(i);
//                            i--;
//                        }
//                        hand.addAll(placeHolder);
//                    }
//                    ArrayList<Card> placeHolder = new ArrayList<>();
//                    int second = 0;
//                    for (int i = 0; i < 4; i++) {
//                        placeHolder.add(hand.get(i));
//                        placeHolder.add(playerTwo.hand.get(second));
//                        second++;
//                    }
//                    for (int i = 0; i < 4; i++) {
//                        hand.remove(0);
//                        playerTwo.hand.remove(0);
//                    }
//                    hand.addAll(placeHolder);