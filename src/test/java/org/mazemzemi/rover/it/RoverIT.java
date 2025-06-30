package org.mazemzemi.rover.it;

import org.junit.jupiter.api.Test;
import org.mazemzemi.rover.domain.Obstacle;
import org.mazemzemi.rover.domain.Position;
import org.mazemzemi.rover.domain.Rover;
import org.mazemzemi.rover.exception.ObstacleEncounteredException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mazemzemi.rover.domain.Direction.EAST;
import static org.mazemzemi.rover.domain.Direction.NORTH;

public class RoverIT {

    @Test
    public void testSimpleMovement() {
        Rover rover = new Rover(new Position(0, 0), NORTH, List.of());
        rover.processCommands("ff".toCharArray());
        assertEquals(new Position(0, 2), rover.getPosition());
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    public void testTurnLeftRight() {
        Rover rover = new Rover(new Position(0, 0), NORTH, List.of());
        rover.processCommands("r".toCharArray());
        assertEquals(EAST, rover.getDirection());

        rover.processCommands("l".toCharArray());
        assertEquals(NORTH, rover.getDirection());
    }

    @Test
    public void testWrapping() {
        Rover rover = new Rover(new Position(9, 9), NORTH, List.of());
        rover.processCommands("f".toCharArray());
        assertEquals(new Position(9, 0), rover.getPosition());
    }

    @Test
    public void testObstacleDetection() {
        Obstacle obstacle = new Obstacle(new Position(0, 1));
        Rover rover = new Rover(new Position(0, 0), NORTH, List.of(obstacle));
        assertThrows(ObstacleEncounteredException.class, () -> rover.processCommands("f".toCharArray()));
    }

    @Test
    public void testBackward() {
        Rover rover = new Rover(new Position(0, 0), NORTH, List.of());
        rover.processCommands("b".toCharArray());
        assertEquals(new Position(0, 9), rover.getPosition());
    }
}

