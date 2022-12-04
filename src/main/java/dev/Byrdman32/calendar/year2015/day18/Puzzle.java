package dev.Byrdman32.calendar.year2015.day18;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle {

    private static boolean[][] animate(boolean[][] grid) {
        boolean[][] newGrid = new boolean[100][100];

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                int neighbours = countNeighbours(grid, x, y);

                if (grid[x][y]) {
                    newGrid[x][y] = neighbours == 2 || neighbours == 3;
                } else {
                    newGrid[x][y] = neighbours == 3;
                }
            }
        }

        return newGrid;
    }

    private static boolean[][] animate2(boolean[][] grid) {
        boolean[][] newGrid = new boolean[100][100];

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {

                if (x == 0 && y == 0 || x == 0 && y == 99 || x == 99 && y == 0 || x == 99 && y == 99) {
                    newGrid[x][y] = true;
                    continue;
                }

                int neighbours = countNeighbours(grid, x, y);

                if (grid[x][y]) {
                    newGrid[x][y] = neighbours == 2 || neighbours == 3;
                } else {
                    newGrid[x][y] = neighbours == 3;
                }
            }
        }

        return newGrid;
    }

    private static int countNeighbours(boolean[][] grid, int x, int y) {
        int count = 0;

        try {
            count += grid[x - 1][y - 1] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }
        try {
            count += grid[x][y - 1] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }
        try {
            count += grid[x + 1][y - 1] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }

        try {
            count += grid[x - 1][y] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }
        try {
            count += grid[x + 1][y] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }

        try {
            count += grid[x - 1][y + 1] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }
        try {
            count += grid[x][y + 1] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }
        try {
            count += grid[x + 1][y + 1] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Ignore
        }

        return count;
    }

    private static int countLights(boolean[][] grid) {
        int count = 0;
        for (boolean[] booleans : grid) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    count++;
                }
            }
        }

        return count;
    }

    public Object solvePart1(List<String> input) {

        boolean[][] grid = new boolean[100][100];

        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    grid[x][y] = true;
                }
            }
        }

        for (int f = 0; f < 100; f++) {
            grid = animate(grid);
        }

        return countLights(grid);
    }

    public Object solvePart2(List<String> input) {

        boolean[][] grid = new boolean[100][100];

        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    grid[x][y] = true;
                }
            }
        }

        grid[0][0] = true;
        grid[99][0] = true;
        grid[99][99] = true;
        grid[0][99] = true;

        for (int f = 0; f < 100; f++) {
            grid = animate2(grid);
        }

        return countLights(grid);
    }
}