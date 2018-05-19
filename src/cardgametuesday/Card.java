/**
 * This class describes a Card object
 *
 * @author Anju Chawla
 * @since May 30, 2017
 * @version 1.0
 */
package cardgametuesday;

import java.util.Arrays;

public class Card {

    //attributes/fields/instance variables
    private String suit;
    private String faceName;
    private int faceValue;
    //class constants
    private static final int MIN_FACE_VALUE = 2;
    private static final int MAX_FACE_VALUE = 14;
    private static final String[] FACES = {
        "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};

    /**
     * This method will create a Card, validating its data
     *
     * @param suit a String to set the suit of the card
     * @param faceName a String to set the face of the card
     * @param faceValue an integer to set the value of the card
     */
    public Card(String suit, String faceName, int faceValue) {
        setSuit(suit);
        setFaceName(faceName);
        setFaceValue(faceValue);

    }//of Constructor

    /**
     * This method returns the suit of the card
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * This method sets the suit of the card after validating it. Valid suits
     * are spades, hearts, diamonds and clubs
     *
     * @param suit to set the suit of the card
     * @throws IllegalArgumentException if the suit is not valid
     */
    public void setSuit(String suit) {
        if (suit.equalsIgnoreCase("spades")
                || suit.equalsIgnoreCase("hearts")
                || suit.equalsIgnoreCase("diamonds")
                || suit.equalsIgnoreCase("clubs")) {
            this.suit = suit.toLowerCase();
        } else {
            throw new IllegalArgumentException("Card suit is invalid. It must be hearts, spades, diamonds or clubs");
        }
    }

    /**
     * This method returns the face name of the card
     *
     * @return the face name of the card
     */
    public String getFaceName() {
        return faceName;
    }

    /**
     * This method sets the face name of the card, if it is valid. Valid face
     * names are "two", "three",
     * "four","five","six","seven","eight","nine","ten","jack","queen","king","ace"
     *
     * @param faceName to set the face name to set
     * @throws IllegalArgumentException if the face name is not valid
     *
     */
    public void setFaceName(String faceName) {
        //sort the FACES list
        Arrays.sort(FACES);
        //search for the faceName in FACES
        if (Arrays.binarySearch(FACES, faceName) >= 0) {
            //found the faceName 
            this.faceName = faceName.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid face name. Valid face names are two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace.");
        }

    }

    /**
     * This method returns the face value of the card
     *
     * @return the face value of the card
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * This method sets the face value of the card after validating it. Valid
     * Face Value >=2 and <=14
     *
     * @param faceValue to set the face value of the card
     * @throws IllegalArgumentException if the face value is not valid
     */
    public void setFaceValue(int faceValue) {
        if (faceValue >= MIN_FACE_VALUE && faceValue <= MAX_FACE_VALUE) {
            this.faceValue = faceValue;
        } else {
            throw new IllegalArgumentException("Card face value must lie between " + MIN_FACE_VALUE + " and " + MAX_FACE_VALUE);
        }

    }

    /**
     * This method returns the Card information
     *
     * @return a String specifying the Card information
     */
    @Override
    public String toString() {
        return getFaceName() + " of " + getSuit();
    }

}