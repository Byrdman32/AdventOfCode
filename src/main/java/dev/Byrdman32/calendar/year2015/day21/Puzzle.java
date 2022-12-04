package dev.Byrdman32.calendar.year2015.day21;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static boolean simulate(int[] boss, int[] player) {
        for (; ; ) {
            boss[0] -= Math.max(1, player[1] - boss[2]);
            if (boss[0] <= 0) return true;
            player[0] -= Math.max(1, boss[1] - player[2]);
            if (player[0] <= 0) return false;
        }
    }
    private int[] calculateCost(List<String> input){

        int[][] weapons = {
                {8, 4, 0},
                {10, 5, 0},
                {25, 6, 0},
                {40, 7, 0},
                {74, 8, 0},
        };

        int[][] armors = {
                {0, 0, 0},
                {13, 0, 1},
                {31, 0, 2},
                {53, 0, 3},
                {75, 0, 4},
                {102, 0, 5},
        };

        int[][] rings = {
                {0, 0, 0},
                {25, 1, 0},
                {50, 2, 0},
                {100, 3, 0},
                {20, 0, 1},
                {40, 0, 2},
                {80, 0, 3},
        };

        int[] maxMin = new int[2];

        maxMin[0] = Integer.MAX_VALUE;
        maxMin[1] = Integer.MIN_VALUE;

        for (int[] w : weapons) {
            for (int[] a : armors) {
                for (int[] r1 : rings) {
                    for (int[] r2 : rings) {
                        if (r1[0] != 0 && r1 == r2) continue;

                        int[] boss = {
                                Integer.parseInt(input.get(0).split(": ")[1]),
                                Integer.parseInt(input.get(1).split(": ")[1]),
                                Integer.parseInt(input.get(2).split(": ")[1])
                        };
                        int[] player = {100, w[1] + a[1] + r1[1] + r2[1], w[2] + a[2] + r1[2] + r2[2]};
                        int cost = w[0] + a[0] + r1[0] + r2[0];

                        if (simulate(boss, player)) {
                            maxMin[0] = Math.min(maxMin[0], cost);
                        } else {
                            maxMin[1] = Math.max(maxMin[1], cost);
                        }
                    }
                }
            }
        }

        return maxMin;
    }

    public Object solvePart1(List<String> input) {

        return calculateCost(input)[0];
    }

    public Object solvePart2(List<String> input) {

        return calculateCost(input)[1];
    }
}