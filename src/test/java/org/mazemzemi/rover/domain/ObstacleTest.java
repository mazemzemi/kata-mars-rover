package org.mazemzemi.rover.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleTest {

    @Test
    void testIsAtSamePosition() {
        Position pos = new Position(3, 4);
        Obstacle obstacle = new Obstacle(pos);
        assertTrue(obstacle.isAt(new Position(3, 4)));
    }

    @Test
    void testIsAtDifferentPosition() {
        Position pos = new Position(3, 4);
        Obstacle obstacle = new Obstacle(pos);
        assertFalse(obstacle.isAt(new Position(0, 0)));
    }

    @Test
    void testGetPosition() {
        Position pos = new Position(5, 5);
        Obstacle obstacle = new Obstacle(pos);
        assertEquals(pos, obstacle.position());
    }
}

