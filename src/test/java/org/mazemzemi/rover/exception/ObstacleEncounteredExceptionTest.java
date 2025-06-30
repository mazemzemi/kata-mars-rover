package org.mazemzemi.rover.exception;

import org.junit.jupiter.api.Test;
import org.mazemzemi.rover.domain.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObstacleEncounteredExceptionTest {

    @Test
    void testExceptionMessage() {
        Position position = new Position(3, 4);
        ObstacleEncounteredException exception = new ObstacleEncounteredException(position);

        assertEquals("Obstacle encountered at position: (3, 4)", exception.getMessage());
    }
}

