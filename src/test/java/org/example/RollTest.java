package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RollTest {

    @Test
    void checkIfMethodCalculatesCorrectlyTheFirstAndSecondRoll() {
        Roll firstRollSpare = new Roll('5');
        Roll secondRollSpare = new Roll('/', firstRollSpare.getKnockedPins());
        Roll firstRollStrike = new Roll('X');
        Roll firstRollMiss = new Roll('-');
        Roll secondRollMiss = new Roll('-', firstRollMiss.getKnockedPins());
        Roll firstRollStandard = new Roll('3');
        Roll secondRollStandard = new Roll('2', firstRollStandard.getKnockedPins());
        Roll firstRollUnusual = new Roll('-');
        Roll secondRollUnusual = new Roll('/', firstRollUnusual.getKnockedPins());

        assertAll(() -> assertEquals(firstRollSpare.getKnockedPins(), 5),
                () -> assertEquals(secondRollSpare.getKnockedPins(), 5),
                () -> assertEquals(firstRollStrike.getKnockedPins(), 10),
                () -> assertEquals(firstRollMiss.getKnockedPins(), 0),
                () -> assertEquals(secondRollMiss.getKnockedPins(), 0),
                () -> assertEquals(firstRollStandard.getKnockedPins(), 3),
                () -> assertEquals(secondRollStandard.getKnockedPins(), 2),
                () -> assertEquals(firstRollUnusual.getKnockedPins(), 0),
                () -> assertEquals(secondRollUnusual.getKnockedPins(), 10));
    }
}
