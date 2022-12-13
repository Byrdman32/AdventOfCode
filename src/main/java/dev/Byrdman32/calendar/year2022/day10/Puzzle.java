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

        var x = 1;
        var cycle = 0;
        char[][] grid = new char[6][40];

        for (var line: input) {
            var parts = line.split(" ");

            if (parts[0].equals("noop")) {
                printPixel(grid, cycle, x);
                cycle++;
            } else if (parts[0].equals("addx")) {
                printPixel(grid, cycle, x);
                cycle++;
                printPixel(grid, cycle, x);
                cycle++;
                x += Integer.parseInt(parts[1]);
            }
        }

        System.out.println();

        for (var line: grid) {
            for (var column: line) {
                System.out.print(column);
            }
            System.out.println();
        }

        return null;
    }

    private int addIfCycleMatch(int cycle, int x) {
        var cycles = List.of(20, 60, 100, 140, 180, 220);

        return cycles.contains(cycle) ? cycle * x : 0;
    }

    private void printPixel(char[][] grid, int cycle, int x) {
        var row = cycle / 40;
        var column = cycle % 40;

        grid[row][column] = x >= column - 1 && x <= column + 1 ? '#' : ' ';
    }
}