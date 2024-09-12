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
        assertAll(() -> assertEquals(frames.get(0).firstLineScore(), 5),
                () -> assertEquals(frames.get(1).firstLineScore(), 0),
                () -> assertEquals(frames.get(2).firstLineScore(), 10),
                () -> assertEquals(frames.get(3).firstLineScore(), 3),
                () -> assertEquals(frames.get(4).firstLineScore(), 0));
    }
    @Test
    void checkIfMethodReturnsCorrectlyTheSecondRoll() {
        assertAll(() -> assertEquals(frames.get(0).secondLineScore(), 5),
                () -> assertEquals(frames.get(1).secondLineScore(), 0),
                () -> assertEquals(frames.get(2).secondLineScore(), 0),
                () -> assertEquals(frames.get(3).secondLineScore(), 2),
                () -> assertEquals(frames.get(4).secondLineScore(), 10));
    }
    @Test
    void checkIfMethodReturnsCorrectlyTheScoreForAFrame() {
        assertAll(() -> assertEquals(frames.get(0).getScore(), 10),
                () -> assertEquals(frames.get(1).getScore(), 0),
                () -> assertEquals(frames.get(2).getScore(), 10),
                () -> assertEquals(frames.get(3).getScore(), 5),
                () -> assertEquals(frames.get(4).getScore(), 10));
    }
}