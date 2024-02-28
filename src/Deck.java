import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deckOfCards = new ArrayList<Card>();



    //iterates over suits arraylist, and faceValues to make sure we get 13 cards for each of the 4 suits with the right color
    public Deck() {
        Card card = new Card();
        int index = 0;
        for (int i = 0; i < card.getSuits().size(); i++) {
            if (i < 2) {
                for (int k = 0; k < card.getFaceValues().size(); k++) {
                    this.deckOfCards.add(index, new Card(card.getFaceValues().get(k),card.getSuits().get(i), "Red"));
                    index++;
                }
            } else {
                for (int k = 0; k < card.getFaceValues().size(); k++) {
                    this.deckOfCards.add(index, new Card(card.getFaceValues().get(k),card.getSuits().get(i), "Black"));
                    index++;
                }
            }
        }
    }

    public void shuffleDeck(Deck deck) {
        Collections.shuffle(deckOfCards);
    } //I just used the built in shuffle method

    public void showDeck() { //just shows the deck
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.println(deckOfCards.get(i).getCard() + "\n");
        }
    }

    public void deal(Player one, Player two) { //deals first half of deck to playerOne and second half to playerTwo
        for (int i = 0; i < 52; i++) {
            if (i < 26) {
                one.getHand().add(deckOfCards.get(i));
            } else {
                two.getHand().add(deckOfCards.get(i));
            }
        }
    }


    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck(deck);
        deck.showDeck();
    }
}
