package org.example;

public class Frame {
    private final String result;
    private final Roll firstRoll;
    private Roll secondRoll;

    public Frame(String result) {
        this.result = result;
        this.firstRoll = new Roll(result.charAt(0));
        if(result.length() == 2)    this.secondRoll = new Roll(result.charAt(1));
    }

    protected boolean isSpare() {
        return result.contains("/");
    }
    protected boolean isStrike() {
        return result.contains("X");
    }
    protected int firstLineScore()    { return firstRoll.getKnockedPins(); }
    protected int secondLineScore()    { return secondRoll != null ? secondRoll.getKnockedPins() : 0; }
    protected int getScore()    {
        return firstLineScore() + secondLineScore();
    }
}
