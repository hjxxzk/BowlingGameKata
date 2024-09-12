package org.example;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private int points;
    private final List<Frame> frames;

    public Line(String[] rolls) {
        this.points = 0;
        this.frames = createFrames(rolls);
    }

    protected int getPoints() {
        return points;
    }
    private List<Frame> createFrames(String[] rolls)  {
        List<Frame> frames = new ArrayList<>();
        for(String frame : rolls)   {
            frames.add(new Frame(frame));
        }
        return frames;
    }
    protected void calculatePoints()  {
        for(int frameIndex = 0; frameIndex < 10; frameIndex++) {
            if(frames.get(frameIndex).isStrike())    addStrikeBonus(frameIndex);
            else if (frames.get(frameIndex).isSpare())  addSpareBonus(frameIndex);
            else points += frames.get(frameIndex).getScore();
        }
    }
    private void addStrikeBonus(int frameIndex)   {
        if(frames.get(frameIndex + 1).isStrike()) {
            points += 20 + frames.get(frameIndex + 2).firstLineScore();
        }   else {
            points += 10 + frames.get(frameIndex + 1).getScore();
        }
    }
    private void addSpareBonus(int frameIndex)   {
        points += 10 + frames.get(frameIndex + 1).firstLineScore();
    }

}
