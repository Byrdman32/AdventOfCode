package dev.Byrdman32.calendar.year2022.day06;

import java.util.ArrayList;
import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private int findUnique(String input, int groupSize) {
        StringBuilder group;
        boolean unique;

        for (int i = 0; i < input.length() - groupSize - 1; i++) {
            unique = true;

            group = new StringBuilder();
            for (int j = 0; j < groupSize; j++) {
                group.append(input.charAt(i + j));
            }

            for (int j = 0; j < group.length(); j++) {
                for (int k = j + 1; k < group.length(); k++) {
                    if (group.charAt(j) == group.charAt(k)) {
                        unique = false;
                        break;
                    }
                }
            }

            if (unique) {
                return i + groupSize;
            }
        }

        return -1;
    }
    public Object solvePart1(List<String> input) {

        return findUnique(input.get(0), 4);
    }

    public Object solvePart2(List<String> input) {

        return findUnique(input.get(0), 14);
    }
}