package org.example;

public class Roll {
    private final int knockedPins;

    public Roll(Character roll) {
        this.knockedPins = determineKnockedPins(roll, 0);
    }
    public Roll(Character roll, int firstRollScore) {
        this.knockedPins = determineKnockedPins(roll, firstRollScore);
    }

    private int determineKnockedPins(Character roll, int firstRollScore)    {
        if(roll == 'X')  return 10;
        if(roll == '-')  return 0;
        if(roll == '/')  return 10 - firstRollScore;
        else return Character.getNumericValue(roll);
    }
    public int getKnockedPins() {
        return knockedPins;
    }
}
