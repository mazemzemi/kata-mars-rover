package org.mazemzemi.rover.domain;

public enum Direction {

    NORTH("N"),

    EAST("E"),

    SOUTH("S"),

    WEST("W");

    private final String value;


    Direction(String value) {
        this.value = value;
    }

    public Direction turnLeft() {
        return values()[(this.ordinal() + 3) % 4];
    }

    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % 4];
    }
}