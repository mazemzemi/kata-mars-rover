package org.mazemzemi.rover.domain;


import org.junit.jupiter.api.Test;
import org.mazemzemi.rover.exception.ObstacleEncounteredException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mazemzemi.rover.domain.Direction.EAST;
import static org.mazemzemi.rover.domain.Direction.NORTH;

class RoverTest {

    @Test
    void testInitialPositionAndDirection() {
        Rover rover = new Rover(new Position(1, 1), NORTH, List.of());
        assertEquals(new Position(1, 1), rover.getPosition());
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    void testForwardMovement() {
        Rover rover = new Rover(new Position(0, 0), EAST, List.of());
        rover.processCommands("f".toCharArray());
        assertEquals(new Position(1, 0), rover.getPosition());
    }

    @Test
    void testBackwardMovement() {
        Rover rover = new Rover(new Position(1, 1), EAST, List.of());
        rover.processCommands("b".toCharArray());
        assertEquals(new Position(0, 1), rover.getPosition());
    }

    @Test
    void testRotation() {
        Rover rover = new Rover(new Position(0, 0), NORTH, List.of());
        rover.processCommands("r".toCharArray());
        assertEquals(EAST, rover.getDirection());
        rover.processCommands("l".toCharArray());
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    void testWrappingAtEdge() {
        Rover rover = new Rover(new Position(9, 9), NORTH, List.of());
        rover.processCommands("f".toCharArray());
        assertEquals(new Position(9, 0), rover.getPosition());
    }

    @Test
    void testObstacleDetectionThrowsException() {
        Rover rover = new Rover(new Position(0, 0), NORTH, List.of(new Obstacle(new Position(0, 1))));
        ObstacleEncounteredException exception = assertThrows(ObstacleEncounteredException.class,
                () -> rover.processCommands("f".toCharArray()));
        assertTrue(exception.getMessage().contains("Obstacle encountered"));
    }

    @Test
    void testStopsBeforeObstacle() {
        Rover rover = new Rover(new Position(0, 0), NORTH,
                List.of(new Obstacle(new Position(0, 2))));
        try {
            rover.processCommands("ff".toCharArray());
        } catch (ObstacleEncounteredException e) {
            assertEquals(new Position(0, 1), rover.getPosition());
        }
    }
}
