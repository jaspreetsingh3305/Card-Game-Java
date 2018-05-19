package cardgametuesday;

/**
 *
 * @author Anju Chawla
 */
public class CardGameTuesday {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        DeckOfCards myDeck = new DeckOfCards();

        System.out.println(myDeck.toString());
        System.out.println("------------------------------------");
        myDeck.shuffle();
        System.out.println(myDeck.toString());
        System.out.println("------------------------------------");
        myDeck.dealTopCard();
        System.out.println(myDeck.toString());
        System.out.println("------------------------------------");
         */
        GameOfWar myGame = new GameOfWar();
        String winner = myGame.playTheGame();
        
        System.out.println("------------------------------------");
        System.out.println(winner);
        System.out.println("------------------------------------");

    }//main

}//tester