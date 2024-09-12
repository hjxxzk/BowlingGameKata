package org.example;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private int points;
    private List<Frame> frames;

    public Line(String[] rolls) {
        this.points = 0;
        this.frames = createFrames(rolls);
    }

    private List<Frame> createFrames(String[] rolls)  {
        List<Frame> frames = new ArrayList<>();
        for(String frame : rolls)   {
            frames.add(new Frame(frame));
        }
        return frames;
    }

    private void calculatePoints()  {

    }

}
