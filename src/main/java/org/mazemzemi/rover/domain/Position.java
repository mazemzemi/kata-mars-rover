package org.mazemzemi.rover.domain;


public record Position(int x, int y) {

    private static final int GRID_SIZE = 10; // Assuming a 10x10 grid for wrap-around

    public Position {
        x = (x % GRID_SIZE + GRID_SIZE) % GRID_SIZE;
        y = (y % GRID_SIZE + GRID_SIZE) % GRID_SIZE;
    }

    public Position move(Direction direction, boolean forward) {
        int deltaX = 0;
        int deltaY = 0;
        int step = forward ? 1 : -1;

        switch (direction) {
            case NORTH:
                deltaY = step;
                break;
            case EAST:
                deltaX = step;
                break;
            case SOUTH:
                deltaY = -step;
                break;
            case WEST:
                deltaX = -step;
                break;
        }

        return new Position(this.x + deltaX, this.y + deltaY);
    }

}