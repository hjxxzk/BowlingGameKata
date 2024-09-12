package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    static List<Line> lines = new ArrayList<>();
    @BeforeAll
    static void simulateDifferentBowlingRolls() {
        lines.add(new Line(new String[]{"X", "7/", "9-", "X", "-8", "8/", "-6", "X", "X", "8/", "9"}));
        lines.add(new Line(new String[]{"X", "X", "X", "9-", "8/", "7/", "6/", "X", "X", "X", "9-"}));
        lines.add(new Line(new String[]{"X", "9-", "X", "X", "9-", "X", "8/", "7/", "X", "X", "9/"}));
        lines.add(new Line(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}));
        lines.add(new Line(new String[]{"9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-"}));
        lines.add(new Line(new String[]{"5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5"}));
    }
    @Test
    void testDifferentScenariosOfLines() {
        lines.get(0).calculatePoints(); assertEquals(lines.get(0).getPoints(), 157);
        lines.get(1).calculatePoints(); assertEquals(lines.get(1).getPoints(), 218);
        lines.get(2).calculatePoints(); assertEquals(lines.get(2).getPoints(), 191);
        lines.get(3).calculatePoints(); assertEquals(lines.get(3).getPoints(), 300);
        lines.get(4).calculatePoints(); assertEquals(lines.get(4).getPoints(), 90);
        lines.get(5).calculatePoints(); assertEquals(lines.get(5).getPoints(), 150);
    }

}