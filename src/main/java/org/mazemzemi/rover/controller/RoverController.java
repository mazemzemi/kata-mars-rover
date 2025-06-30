package org.mazemzemi.rover.controller;


import org.mazemzemi.rover.domain.Direction;
import org.mazemzemi.rover.domain.Obstacle;
import org.mazemzemi.rover.domain.Position;
import org.mazemzemi.rover.domain.Rover;

import java.util.List;

public class RoverController {
    public Rover initializeRover(int x, int y, Direction direction, List<Obstacle> obstacles) {
        return new Rover(new Position(x, y), direction, obstacles);
    }

    public void executeCommands(Rover rover, String commandString) {
        rover.processCommands(commandString.toCharArray());
    }
}

