package dev.Byrdman32.calendar.year2015.day06;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int[][] grid = new int[1000][1000];
        int count = 0;

        for (String s : input) {
            String[] split = s.split(" ");
            String[] start = split[split.length - 3].split(",");
            String end = split[split.length - 1];
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);
            int endX = Integer.parseInt(end.split(",")[0]);
            int endY = Integer.parseInt(end.split(",")[1]);

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (split[0].equals("toggle")) {
                        grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                    } else if (split[1].equals("on")) {
                        grid[i][j] = 1;
                    } else if (split[1].equals("off")) {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public Object solvePart2(List<String> input) {

        int[][] grid = new int[1000][1000];
        int brightness = 0;

        for (String s : input) {
            String[] split = s.split(" ");
            String[] start = split[split.length - 3].split(",");
            String end = split[split.length - 1];
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);
            int endX = Integer.parseInt(end.split(",")[0]);
            int endY = Integer.parseInt(end.split(",")[1]);

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (split[0].equals("toggle")) {
                        grid[i][j] += 2;
                    } else if (split[1].equals("on")) {
                        grid[i][j]++;
                    } else if (split[1].equals("off")) {
                        grid[i][j] = grid[i][j] == 0 ? 0 : grid[i][j] - 1;
                    }
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                brightness += grid[i][j];
            }
        }

        return brightness;
    }
}