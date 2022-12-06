package dev.Byrdman32.calendar.year2022.day06;

import java.util.ArrayList;
import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        List<Character> uniqueChars = new ArrayList<>();
        String group = "";
        boolean unique;

        for (int i = 0; i < input.get(0).length() - 3; i++) {
            unique = true;
            group = "" + input.get(0).charAt(i) + input.get(0).charAt(i + 1) + input.get(0).charAt(i + 2) + input.get(0).charAt(i + 3);

            for (int j = 0; j < group.length(); j++) {
                for (int k = j + 1; k < group.length(); k++) {
                    if (group.charAt(j) == group.charAt(k)) {
                        unique = false;
                        break;
                    }
                }
            }

            if (unique) {
                return i + 4;
            }
        }

        return null;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}