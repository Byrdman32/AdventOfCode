package dev.Byrdman32.calendar.year2015.day03;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int x = 500;
        int y = 500;
        int count = 0;

        char[][] grid = new char[1000][1000];
        grid[x][y] = 'X';

        for (char c : input.get(0).toCharArray()) {
            switch (c) {
                case '^' -> y++;
                case 'v' -> y--;
                case '>' -> x++;
                case '<' -> x--;
            }
            grid[x][y] = 'X';
        }

        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    count++;
                }
            }
        }

        return count;
    }

    public Object solvePart2(List<String> input) {

        int x = 500;
        int y = 500;
        int x2 = 500;
        int y2 = 500;
        int houses = 0;
        char c = ' ';

        char[][] grid = new char[1000][1000];
        grid[x][y] = 'X';

        for (char d : input.get(0).toCharArray()) {
            if (c == 'S') {
                switch (d) {
                    case '^' -> y++;
                    case 'v' -> y--;
                    case '>' -> x++;
                    case '<' -> x--;
                }
                grid[x][y] = 'X';
                c = 'R';
            } else {
                switch (d) {
                    case '^' -> y2++;
                    case 'v' -> y2--;
                    case '>' -> x2++;
                    case '<' -> x2--;
                }
                grid[x2][y2] = 'X';
                c = 'S';
            }
        }

        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    houses++;
                }
            }
        }

        return houses;
    }
}