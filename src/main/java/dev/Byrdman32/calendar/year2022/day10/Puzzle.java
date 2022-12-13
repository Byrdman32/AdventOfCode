package dev.Byrdman32.calendar.year2022.day10;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        var x = 1;
        var cycle = 1;
        var sum = 0;

        for (var line: input) {
            var parts = line.split(" ");

            if (parts[0].equals("noop")) {
                sum += addIfCycleMatch(cycle, x);
                cycle++;
            } else if (parts[0].equals("addx")) {
                sum += addIfCycleMatch(cycle, x);
                cycle++;
                sum += addIfCycleMatch(cycle, x);
                cycle++;
                x += Integer.parseInt(parts[1]);
            }
        }

        return String.valueOf(sum);
    }

    public Object solvePart2(List<String> input) {

        return null;
    }

    private int addIfCycleMatch(int cycle, int x) {
        var cycles = List.of(20, 60, 100, 140, 180, 220);

        return cycles.contains(cycle) ? cycle * x : 0;
    }
}