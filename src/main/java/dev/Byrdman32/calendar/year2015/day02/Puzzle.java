package dev.Byrdman32.calendar.year2015.day02;

import java.util.Arrays;
import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int total = 0;

        for (String s : input) {
            int[] i = new int[3];

            for (int j = 0; j < 3; j++) {
                i[j] = Integer.parseInt(s.split("x")[j]);
            }

            total += 2 * i[0] * i[1] + 2 * i[1] * i[2] + 2 * i[2] * i[0] + Math.min(i[0] * i[1], Math.min(i[1] * i[2], i[2] * i[0]));
        }

        return total;
    }

    public Object solvePart2(List<String> input) {

        int total = 0;

        for (String s : input) {
            int[] i = new int[3];

            for (int j = 0; j < 3; j++) {
                i[j] = Integer.parseInt(s.split("x")[j]);
            }

            Arrays.sort(i);

            total += (i[0] * i[1] * i[2]) + (2 * i[0]) + (2 * i[1]);
        }

        return total;
    }
}