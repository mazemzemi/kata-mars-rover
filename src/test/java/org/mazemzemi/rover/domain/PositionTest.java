package org.mazemzemi.rover.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mazemzemi.rover.domain.Direction.NORTH;
import static org.mazemzemi.rover.domain.Direction.SOUTH;

class PositionTest {

    @Test
    @DisplayName("goes to (0, 1)")
    void testMoveForwardNorth() {
        Position position = new Position(0, 0);
        Position newPos = position.move(NORTH, true);
        assertEquals(new Position(0, 1), newPos);
    }

    @Test
    @DisplayName("Back = North")
    void testMoveBackwardSouth() {
        Position position = new Position(0, 0);
        Position newPos = position.move(SOUTH, false);
        assertEquals(new Position(0, 1), newPos);
    }

    @Test
    @DisplayName("goes to (0, -1) → wraps to (0,9)")
    void testMoveWithWrapping() {
        Position position = new Position(0, 0);
        Position newPos = position.move(SOUTH, true);
        assertEquals(new Position(0, 9), newPos);
    }
}

