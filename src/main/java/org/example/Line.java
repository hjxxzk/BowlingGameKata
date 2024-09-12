package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a line in a game of bowling.
 * Class responsible for calculating the final number of points scored in one line.
 */
public class Line {

    private int points;
    private final List<Frame> frames;

    /**
     * Constructor for the Line class.
     * Initializes the frames based on the provided rolls and sets the initial score to 0.
     *
     * @param rolls An array of strings representing the rolls in each frame.
     */
    public Line(String[] rolls) {
        this.points = 0;
        this.frames = createFrames(rolls);
    }

    /**
     * Returns the total score for the line.
     *
     * @return The total score.
     */
    protected int getPoints() {
        return points;
    }

    /**
     * Creates a list of frames in the line.
     *
     * @param rolls An array of strings representing the rolls.
     * @return A list of Frame objects.
     */
    private List<Frame> createFrames(String[] rolls)  {
        List<Frame> frames = new ArrayList<>();
        for(String frame : rolls)   {
            frames.add(new Frame(frame));
        }
        return frames;
    }

    /**
     * Calculates the total score for the line based on the frames.
     */
    protected void calculatePoints()  {
        for(int frameIndex = 0; frameIndex < 10; frameIndex++) {
            if(frames.get(frameIndex).isStrike())   addStrikeBonus(frameIndex);
            else if (frames.get(frameIndex).isSpare())  addSpareBonus(frameIndex);
            else points += frames.get(frameIndex).getScore();
        }
    }

    /**
     * Adds bonus points for a strike by including 10 points plus the score of the next two rolls.
     * Handles the case where the next roll is also a strike by including the score of the roll following the next frame.
     */
    private void addStrikeBonus(int frameIndex)   {
        if(frames.get(frameIndex + 1).isStrike()) {
            points += 20 + frames.get(frameIndex + 2).firstLineScore();
        }   else {
            points += 10 + frames.get(frameIndex + 1).getScore();
        }
    }

    /**
     * Adds bonus points for a spare by including 10 points plus the score of the first roll in the next frame.
     */
    private void addSpareBonus(int frameIndex)   {
        points += 10 + frames.get(frameIndex + 1).firstLineScore();
    }

}
