package org.mazemzemi.rover.controller;


import org.junit.jupiter.api.Test;
import org.mazemzemi.rover.domain.Obstacle;
import org.mazemzemi.rover.domain.Position;
import org.mazemzemi.rover.domain.Rover;
import org.mazemzemi.rover.exception.ObstacleEncounteredException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mazemzemi.rover.domain.Direction.*;

class RoverControllerTest {

    @Test
    void testInitializeRover() {
        RoverController controller = new RoverController();
        Rover rover = controller.initializeRover(2, 3, WEST, List.of());

        assertEquals(new Position(2, 3), rover.getPosition());
        assertEquals(WEST, rover.getDirection());
    }

    @Test
    void testExecuteValidCommands() {
        RoverController controller = new RoverController();
        Rover rover = controller.initializeRover(0, 0, NORTH, List.of());

        controller.executeCommands(rover, "ffrff");

        assertEquals(new Position(2, 2), rover.getPosition());
        assertEquals(EAST, rover.getDirection());
    }

    @Test
    void testExecuteWithObstacle() {
        RoverController controller = new RoverController();
        List<Obstacle> obstacles = List.of(new Obstacle(new Position(0, 1)));
        Rover rover = controller.initializeRover(0, 0, NORTH, obstacles);

        ObstacleEncounteredException ex = assertThrows(ObstacleEncounteredException.class, () ->
                controller.executeCommands(rover, "ff"));

        assertEquals("Obstacle encountered at position: (0, 1)", ex.getMessage());
    }
}

