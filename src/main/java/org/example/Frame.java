package org.example;

/**
 * Represents a single frame in a game of bowling.
 * Class responsible for providing information about the result of one frame.
 */
public class Frame {
    private final String result;
    private final Roll firstRoll;
    private Roll secondRoll;

    /**
     * Constructor for a Frame class. If the first roll was not a strike, it initializes the secondRoll field.
     *
     * @param result A string representing the result of the frame (e.g., "X", "7/", "45")
     */
    public Frame(String result) {
        this.result = result;
        this.firstRoll = new Roll(result.charAt(0));
        if(result.length() == 2)    this.secondRoll = new Roll(result.charAt(1), firstRoll.getKnockedPins());
    }

    /**
     * Checks if the frame is a spare.
     * A frame is a spare if the total pins knocked down in the frame is 10, with the second roll being '/'.
     *
     * @return True if the frame is a spare, false otherwise
     */
    protected boolean isSpare() {
        return result.contains("/");
    }

    /**
     * Checks if the frame is a strike. A frame is a strike if the first roll is 'X'.
     *
     * @return True if the frame is a strike, false otherwise
     */
    protected boolean isStrike() {
        return result.contains("X");
    }

    /**
     * Gets the score for the first roll.
     *
     * @return The number of pins knocked down in the first roll
     */
    protected int firstLineScore()    { return firstRoll.getKnockedPins(); }

    /**
     * Gets the score for the second roll. If there is no second roll (the frame is a strike), returns 0.
     *
     * @return The number of pins knocked down in the first roll
     */
    protected int secondLineScore()    { return secondRoll != null ? secondRoll.getKnockedPins() : 0; }

    /**
     * Calculates the total score for the frame.
     *
     * @return The total score for the frame, which is the sum of the scores of the first and second rolls
     */
    protected int getScore()    { return firstLineScore() + secondLineScore(); }
}
