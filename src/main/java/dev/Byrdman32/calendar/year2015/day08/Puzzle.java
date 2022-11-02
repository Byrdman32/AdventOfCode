package dev.Byrdman32.calendar.year2015.day08;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int total = 0;
        int total2 = 0;

        for (String s : input) {
            total += s.length();

            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i) == '\\') {
                    if (s.charAt(i + 1) == 'x') {
                        i += 3;
                    } else {
                        i++;
                    }
                }

                total2++;
            }
        }
        return total - total2;
    }

    public Object solvePart2(List<String> input) {

        int total = 0;
        int total2 = 0;

        for (String s : input) {
            total += s.length();

            total2 += 2;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '\\' || s.charAt(i) == '"') {
                    total2++;
                }

                total2++;
            }
        }

        return total2 - total;
    }
}