package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    static List<Frame> frames = new ArrayList<>();
    @BeforeAll
    static void createFramesForTesting() {
        frames.add(new Frame("5/"));
        frames.add(new Frame("--"));
        frames.add(new Frame("X"));
        frames.add(new Frame("32"));
        frames.add(new Frame("-/"));
    }
    @Test
    void checkIfMethodCalculatesCorrectlyWhenSpare() {
        assertAll(() -> assertTrue(frames.get(0).isSpare()),
                () -> assertFalse(frames.get(1).isSpare()),
                () -> assertFalse(frames.get(2).isSpare()),
                () -> assertFalse(frames.get(3).isSpare()),
                () -> assertTrue(frames.get(4).isSpare()));
    }
    @Test
    void checkIfMethodCalculatesCorrectlyWhenStrike() {
        assertAll(() -> assertFalse(frames.get(0).isStrike()),
                () -> assertFalse(frames.get(1).isStrike()),
                () -> assertTrue(frames.get(2).isStrike()),
                () -> assertFalse(frames.get(3).isStrike()),
                () -> assertFalse(frames.get(4).isStrike()));
    }
    @Test
    void checkIfMethodReturnsCorrectlyTheFirstRoll() {
        assertAll(() -> assertEquals(frames.get(0).getFirstLineScore(), 5),
                () -> assertEquals(frames.get(1).getFirstLineScore(), 0),
                () -> assertEquals(frames.get(2).getFirstLineScore(), 10),
                () -> assertEquals(frames.get(3).getFirstLineScore(), 3),
                () -> assertEquals(frames.get(4).getFirstLineScore(), 0));
    }
    @Test
    void checkIfMethodReturnsCorrectlyTheSecondRoll() {
        assertAll(() -> assertEquals(frames.get(0).getSecondLineScore(), 5),
                () -> assertEquals(frames.get(1).getSecondLineScore(), 0),
                () -> assertEquals(frames.get(2).getSecondLineScore(), 0),
                () -> assertEquals(frames.get(3).getSecondLineScore(), 2),
                () -> assertEquals(frames.get(4).getSecondLineScore(), 10));
    }
    @Test
    void checkIfMethodReturnsCorrectlyTheScoreForAFrame() {
        assertAll(() -> assertEquals(frames.get(0).getSummaryScore(), 10),
                () -> assertEquals(frames.get(1).getSummaryScore(), 0),
                () -> assertEquals(frames.get(2).getSummaryScore(), 10),
                () -> assertEquals(frames.get(3).getSummaryScore(), 5),
                () -> assertEquals(frames.get(4).getSummaryScore(), 10));
    }
}