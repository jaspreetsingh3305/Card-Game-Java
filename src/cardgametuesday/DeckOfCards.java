package cardgametuesday;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a deck of cards
 *
 * @author Anju Chawla
 * @since May 30, 2017
 * @version 1.0
 */
public class DeckOfCards {

    //instance variables
    private ArrayList<Card> deck;

    /**
     * This constructor creates a deck of cards with 52 cards, 13 of ech suit
     */
    public DeckOfCards() {
        String[] suits = {"spades", "diamonds", "hearts", "clubs"};
        String[] faceNames = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
        deck = new ArrayList<Card>();
        /*
        for(int i=0; i <suits.length ; i++)
        {
            String suit = suits[i];
        //other computations
        }
         */
        for (String suit : suits) {
            for (int i = 0; i < faceNames.length; i++) {
                Card newCard = new Card(suit, faceNames[i], i + 2);
                deck.add(newCard);
            }//for
        }//for

    }//constructor

    /**
     * This method shuffles the deck of cards
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }//shuffle

    /**
     * This method 'deals' the top card of the deck
     */
    public Card dealTopCard() {
        //if there are cards in the deck
        if (deck.size() > 0) {
            return deck.remove(0);
        } else {
            return null;
        }
    }//dealTopCard
    
    /**
     * This method returns the cards information in the deck as a string
     * @return a String representation of the cards in the deck
     */
    @Override
    public String toString()
    {
        String deckString ="";  //= new String("");
        
        for(Card card: deck)
        {
            deckString = deckString + card.toString()+"\n";
        }
        return deckString;
    }//toString

}//class