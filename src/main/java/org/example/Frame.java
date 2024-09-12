package org.example;

/**
 * Represents a single frame in a game of bowling.
 * Class responsible for providing information about the result of one frame.
 */
public class Frame {
    private final String result;
    private final Roll firstRoll;
    private Roll secondRoll;


    //Constructor for a Frame class. If the first roll was not a strike, it initializes the secondRoll field.
    public Frame(String result) {
        this.result = result;
        this.firstRoll = new Roll(result.charAt(0));
        if(result.length() == 2)    this.secondRoll = new Roll(result.charAt(1), firstRoll.getKnockedPins());
    }

    //Checks if the frame is a spare. A frame is a spare if the total pins knocked down in the frame is 10, with the second roll being '/'.
    protected boolean isSpare() {
        return result.contains("/");
    }

    //Checks if the frame is a strike. A frame is a strike if the first roll is 'X'.
    protected boolean isStrike() {
        return result.contains("X");
    }

    protected int getFirstLineScore()    { return firstRoll.getKnockedPins(); }

    protected int getSecondLineScore()    { return secondRoll != null ? secondRoll.getKnockedPins() : 0; }

    protected int getSummaryScore()    { return getFirstLineScore() + getSecondLineScore(); }
}
