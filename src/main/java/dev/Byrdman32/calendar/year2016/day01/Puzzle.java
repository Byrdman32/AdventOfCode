package dev.Byrdman32.calendar.year2016.day01;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    enum direction {
        NORTH, EAST, SOUTH, WEST
    }

    public Object solvePart1(List<String> input) {

        int x = 0;
        int y = 0;

        direction currentDirection = direction.NORTH;

        for (String s : input) {
            String[] split = s.split(", ");
            for (String s2 : split) {
                char turn = s2.charAt(0);
                int steps = Integer.parseInt(s2.substring(1));
                switch (turn) {
                    case 'L' -> currentDirection = switch (currentDirection) {
                        case NORTH -> direction.WEST;
                        case EAST -> direction.NORTH;
                        case SOUTH -> direction.EAST;
                        case WEST -> direction.SOUTH;
                    };
                    case 'R' -> currentDirection = switch (currentDirection) {
                        case NORTH -> direction.EAST;
                        case EAST -> direction.SOUTH;
                        case SOUTH -> direction.WEST;
                        case WEST -> direction.NORTH;
                    };
                }

                switch (currentDirection) {
                    case NORTH -> y += steps;
                    case EAST -> x += steps;
                    case SOUTH -> y -= steps;
                    case WEST -> x -= steps;
                }
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}