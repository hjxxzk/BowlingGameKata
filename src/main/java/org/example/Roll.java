package org.example;

/**
 * Represents a single roll in a game of bowling.
 * Class responsible for calculating the number of knocked down pins in a single roll.
 */
public class Roll {
    private final int knockedPins;

    //Constructor for a first roll.
    public Roll(Character roll) {
        this.knockedPins = determineKnockedPins(roll, 0);
    }

    //Constructor for a second roll, using the roll value and optionally the score of the first roll.
    public Roll(Character roll, int firstRollScore) {
        this.knockedPins = determineKnockedPins(roll, firstRollScore);
    }

    //Determines the number of pins knocked down in this roll.
    private int determineKnockedPins(Character roll, int firstRollScore)    {
        return switch (roll) {
            case 'X' -> 10;
            case '-' -> 0;
            case '/' -> 10 - firstRollScore;
            default -> Character.getNumericValue(roll);
        };
    }
    protected int getKnockedPins() { return knockedPins; }
}
