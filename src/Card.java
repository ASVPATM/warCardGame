import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {


    private int value = 0;
    private String faceVal = "";
    private String suit = "";
    private String color = "";
    //making card class with arraylist for each parameter
    //initialized it one line instead of iterating
    private ArrayList<String> faceValues = new ArrayList<String>
            (Arrays.asList("A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "K", "Q", "J"));

     private ArrayList<String> suits = new ArrayList<String>(Arrays.asList(
            "Hearts", "Diamonds", "Spades", "Clubs"));

    //might get rid of colors list
     private ArrayList<String> colors = new ArrayList<String>(
            Arrays.asList("Red", "Black"));



    public Card(String faceVal, String suit, String color) {
        if (faceValues.contains(faceVal)) {
            this.faceVal = faceVal;
        }
        if (suits.contains(suit)) {
            this.suit = suit;
        }
        if (colors.contains(color)) {
            this.color = color;
        }
    }

    //Second constructor for Random Card
    public Card() {
        this.faceVal = faceValues.get( ((int) ((Math.random()) * faceValues.size())));
        this.suit = suits.get( ((int) ((Math.random()) * suits.size())));
        this.color = colors.get( ((int) ((Math.random()) * colors.size())));
    }

    public ArrayList<String> getFaceValues() {
        return faceValues;
    }

    public ArrayList<String> getSuits() {
        return suits;
    }

    public ArrayList<String> getColors() {
        return colors;
    }


    public String getFaceVal() {
        return faceVal;
    }

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        if (faceVal.equals("A")) {
            return 14;
        } else if (faceVal.equals("K")) {
            return 13;
        } else if (faceVal.equals("Q")) {
            return 12;
        } else if (faceVal.equals("J")) {
            return 11;
        }
        return Integer.parseInt(faceVal);
    }

    //just to get all values of card if you want to
    public String getCard() {
        return "FaceVal = " + faceVal +"\n"
                + "Suit = " + suit + "\n"
                + "Color = " + color;
    }

    public static void main(String[] args) {
        Card one = new Card("4", "Hearts", "Red");
        System.out.println(one.getValue());
    }
}
