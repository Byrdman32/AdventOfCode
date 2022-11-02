package dev.Byrdman32.calendar.year2015.day01;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int floor = 0;

        for (int i = 0; i < input.get(0).length(); i++) {
            if (input.get(0).charAt(i) == '(') {
                floor++;
            } else {
                floor--;
            }
        }

        return floor;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}