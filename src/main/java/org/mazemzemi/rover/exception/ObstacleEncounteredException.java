package org.mazemzemi.rover.exception;


import org.mazemzemi.rover.domain.Position;

public class ObstacleEncounteredException extends RuntimeException {
    public ObstacleEncounteredException(Position position) {
        super("Obstacle encountered at position: (" + position.x() + ", " + position.y() + ")");
    }
}
