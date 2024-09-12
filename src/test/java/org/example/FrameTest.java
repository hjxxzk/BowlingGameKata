package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    static List<Frame> frames = new ArrayList<>();
    @BeforeAll
    static void createFrames() {
        frames.add(new Frame("5/"));
        frames.add(new Frame("--"));
        frames.add(new Frame("X"));
        frames.add(new Frame("32"));
        frames.add(new Frame("-/"));
    }
    @Test
    void isSpare() {
        assertAll(() -> assertTrue(frames.get(0).isSpare()),
                () -> assertFalse(frames.get(1).isSpare()),
                () -> assertFalse(frames.get(2).isSpare()),
                () -> assertFalse(frames.get(3).isSpare()),
                () -> assertTrue(frames.get(4).isSpare()));
    }

    @Test
    void isStrike() {
        assertAll(() -> assertFalse(frames.get(0).isStrike()),
                () -> assertFalse(frames.get(1).isStrike()),
                () -> assertTrue(frames.get(2).isStrike()),
                () -> assertFalse(frames.get(3).isStrike()),
                () -> assertFalse(frames.get(4).isStrike()));
    }
}