package org.example;

public class Frame {
    private final String result;

    public Frame(String result) {
        this.result = result;
    }

    protected boolean isSpare() {
        return result.contains("/");
    }
    protected boolean isStrike() {
        return result.contains("X");
    }
    protected int firstLineScore()    {
        if(isStrike())  return 10;
        if(result.charAt(0) == '-')    return 0;
        else return Character.getNumericValue(result.charAt(0));
    }
    protected int secondLineScore()    {
        if(isStrike())  return 0;
        if(isSpare())  return (10 - Character.getNumericValue(result.charAt(0)));
        if(result.charAt(1) == '-')    return 0;
        else return Character.getNumericValue(result.charAt(1));
    }
    protected int getScore()    {
        return firstLineScore() + secondLineScore();
    }
}
