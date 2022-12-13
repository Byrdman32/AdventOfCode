package dev.Byrdman32.calendar.year2022.day12;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle {

    public void checkPoint(Map<Point, Integer> grid, Point p, Point dir, Map<Point, Integer> shortestPath, List<Point> queue) {
        int gridHeight = grid.get(dir);
        if (gridHeight - grid.get(p) <= 1) {
            int pathLen = shortestPath.get(p) + 1;

            if (shortestPath.getOrDefault(dir, Integer.MAX_VALUE) > pathLen) {
                queue.add(dir);
                shortestPath.put(dir, pathLen);
            }
        }
    }

    public Object solvePart1(List<String> input) {

        Map<Point, Integer> grid = new HashMap<>();
        Map<Point, Integer> shortestPath = new HashMap<>();

        Point start = null;
        Point end = null;

        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            for (int j = 0; j < s.length(); j++) {
                Point p = new Point(i, j);
                char c = s.charAt(j);

                if (c == 'S') {
                    start = p;
                    c = 'a';
                } else if (c == 'E') {
                    end = p;
                    c = 'z';
                }

                grid.put(p, c - 'a');
            }
        }

        shortestPath.put(start, 0);
        List<Point> queue = new ArrayList<>();
        queue.add(start);
        while (queue.size() > 0) {
            Point p = queue.remove(0);

            if (p.getX() != 0)
                checkPoint(grid, p, new Point((int) (p.getX() - 1), (int) p.getY()), shortestPath, queue);
            if (p.getX() != input.size() - 1)
                checkPoint(grid, p, new Point((int) (p.getX() + 1), (int) p.getY()), shortestPath, queue);
            if (p.getY() != 0)
                checkPoint(grid, p, new Point((int) p.getX(), (int) (p.getY() - 1)), shortestPath, queue);
            if (p.getY() != input.get(0).length() - 1)
                checkPoint(grid, p, new Point((int) p.getX(), (int) (p.getY() + 1)), shortestPath, queue);
        }

        return shortestPath.get(end);
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}