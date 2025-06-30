package org.mazemzemi.rover.domain;

import org.mazemzemi.rover.exception.ObstacleEncounteredException;

import java.util.List;
import java.util.Objects;


public class Rover {
    private Position position;
    private Direction direction;
    private final List<Obstacle> obstacles;

    public Rover(Position initialPosition, Direction initialDirection, List<Obstacle> obstacles) {
        this.position = Objects.requireNonNull(initialPosition, "Initial position cannot be null.");
        this.direction = Objects.requireNonNull(initialDirection, "Initial direction cannot be null.");
        this.obstacles = Objects.requireNonNull(obstacles, "Obstacle list cannot be null.");
    }

    public void processCommands(char[] commands) {
        for (char command : commands) {
            switch (command) {
                case 'f':
                    move(true);
                    break;
                case 'b':
                    move(false);
                    break;
                case 'l':
                    direction = direction.turnLeft();
                    break;
                case 'r':
                    direction = direction.turnRight();
                    break;
                default:
                    System.err.println("Unknown command: " + command);
                    break;
            }
        }
    }

    private void move(boolean forward) {
        Position nextPosition = position.move(direction, forward);

        for (Obstacle obstacle : obstacles) {
            if (obstacle.isAt(nextPosition)) {
                throw new ObstacleEncounteredException(nextPosition);
            }
        }
        this.position = nextPosition;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Rover at " + position + " facing " + direction;
    }
}