package org.mazemzemi.rover;

import org.mazemzemi.rover.controller.RoverController;
import org.mazemzemi.rover.domain.Obstacle;
import org.mazemzemi.rover.domain.Position;
import org.mazemzemi.rover.domain.Rover;

import java.util.List;

import static org.mazemzemi.rover.domain.Direction.NORTH;

public class Main {
    public static void main(String[] args) {
        RoverController controller = new RoverController();
        List<Obstacle> obstacles = List.of(new Obstacle(new Position(1, 2)));

        Rover rover = controller.initializeRover(0, 0, NORTH, obstacles);
        try {
            controller.executeCommands(rover, "fffff");
            System.out.println("Final position: (" + rover.getPosition().x() + ", " + rover.getPosition().y()+ ")");
            System.out.println("Facing: " + rover.getDirection());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}