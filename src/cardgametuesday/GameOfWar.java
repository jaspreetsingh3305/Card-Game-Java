package cardgametuesday;

import java.util.ArrayList;

/**
 * This class simulates the War Game
 *
 * @author Anju Chawla
 * @since June 6, 2017
 * @version 1.0
 */
public class GameOfWar {

    //instance variables
    private ArrayList<Card> p1Hand;  //to store the players 1 cards
    private ArrayList<Card> p2Hand;  //to store player 2 cards

    //constants
    private static final int TOTAL_CARDS = 52;

    /**
     * This method simulates the game object
     */
    public GameOfWar() {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();

        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();

        dealTheCards(theDeck);
    }  //end of the constructor

    /**
     * This method will "deal" all of the cards to the players
     *
     * @param DeckOfCards the deck of cards for the game
     */
    private void dealTheCards(DeckOfCards theDeck) {
        for (int cardNumber = 0; cardNumber < TOTAL_CARDS; cardNumber++) {
            if (cardNumber % 2 == 0) //cards in even positions
            {
                p1Hand.add(theDeck.dealTopCard());
            } else {
                p2Hand.add(theDeck.dealTopCard());
            }
        }
    }

    /**
     * This method will simulate playing the Game called "War"
     */
    public String playTheGame() {
        //while both 'players' have cards to play
        while (!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
            playHand();
        }
    //player 1 has no more cards, hence player 2 is the winner
        if (p1Hand.isEmpty()) //p1Hand.size() == 0
        {
            return "Player 2 is the winner!";
        } 
        //player 2 has no more cards, hence player 1 is the winner
        else {
            return "Player 1 is the winner!";
        }
    }

    /**
     * This method will simulate playing 1 hand at the game of war
     */
    private void playHand() {
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);

        //no printing in class definition. Placed here  to check if working properly
    System.out.printf("Player 1 card is %s and has %d cards in hand.%n", p1Card, p1Hand.size() + 1);
    System.out.printf("Player 2 card is %s and has %d cards in hand.%n", p2Card, p2Hand.size() + 1);

        //player 1's card is higher than player 2's card
        if (p1Card.getFaceValue() > p2Card.getFaceValue()) {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        } //player 2's card is higher than player 1's
        else if (p2Card.getFaceValue() > p1Card.getFaceValue()) {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        } //otherwise it's WAR
        else {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }  //end of method playHand()

    /**
     * This method will simulate playing the "war" hand
     */
    private void playWarHand(ArrayList<Card> warPile) {
        final int MINIMUM_CARDS = 3;

        //check if player 1 has enough cards to play further
        if (p1Hand.size() < MINIMUM_CARDS) {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        }

        //check if player 2 has enough cards to even play further
        if (p2Hand.size() < MINIMUM_CARDS) {
            p1Hand.addAll(p2Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }

        //each player puts 2 cards on the pile and then compares the 3rd card
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));

        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);

        System.out.printf("%n%n ~~~~~~~~~~~ WAR ~~~~~~~~~~~~~%n");
        System.out.printf("Player 1 card is %s and has %d cards in hand%n", p1Card, p1Hand.size() + 1);
        System.out.printf("Player 2 card is %s and has %d cards in hand%n", p2Card, p2Hand.size() + 1);
        System.out.printf("%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n");

        //if player 1 card is higher
        if (p1Card.getFaceValue() > p2Card.getFaceValue()) {
            p1Hand.addAll(warPile); //gets all  cards from war pile
            p1Hand.add(p1Card);//keeps his/her card
            p1Hand.add(p2Card); //gets player 2 card
        } //if player 2 card is higher
        else if (p2Card.getFaceValue() > p1Card.getFaceValue()) {
            p2Hand.addAll(warPile);
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        } else {
            warPile.add(p1Card);
            warPile.add(p2Card);
            this.playWarHand(warPile);  //method 'calls' itself since needs to repeat the process
        }
    }   //end of the method playWarHand

}   //end of the class