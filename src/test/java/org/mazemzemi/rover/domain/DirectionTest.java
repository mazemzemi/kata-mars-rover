package org.mazemzemi.rover.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @ParameterizedTest
    @CsvSource({"WEST, NORTH", "SOUTH, WEST", "EAST, SOUTH", "NORTH, EAST"})
    void testTurnLeft(Direction expected, Direction actual) {
        assertEquals(expected, actual.turnLeft());
    }

    @ParameterizedTest
    @CsvSource({"EAST, NORTH", "SOUTH, EAST", "WEST, SOUTH", "NORTH, WEST"})
    void testTurnRight(Direction expected, Direction actual) {
        assertEquals(expected, actual.turnRight());
    }
}
