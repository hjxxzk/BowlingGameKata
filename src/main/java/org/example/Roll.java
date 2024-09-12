package org.example;

public class Roll {
    private final int knockedPins;

    public Roll(Character roll) {
        this.knockedPins = determineKnockedPins(roll);
    }

    private int determineKnockedPins(Character roll)    {
        if(roll == 'X')  return 10;
        if(roll == '/')  return 10 - Character.getNumericValue(roll);
        if(roll == '-')  return 0;
        else return Character.getNumericValue(roll);
    }
    public int getKnockedPins() {
        return knockedPins;
    }
}
