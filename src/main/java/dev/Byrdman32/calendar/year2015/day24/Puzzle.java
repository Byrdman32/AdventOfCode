package dev.Byrdman32.calendar.year2015.day24;

import java.util.List;
import java.util.stream.IntStream;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static long divide(int[] sizes, int divisions) {
        int pack = IntStream.of(sizes).sum() / divisions;
        long min = Long.MAX_VALUE;
        for (int l = 1; l < sizes.length; l++) {
            for (int i = (1 << l) - 1; i > 0; i = next(i)) {

                long sum = 0;
                long prod = 1;
                for (int b = 0; b < sizes.length; b++) {
                    if ((i & (1 << b)) != 0) {
                        sum += sizes[b];
                        prod *= sizes[b];
                    }
                }
                if (sum == pack) {
                    min = Math.min(min, prod);
                }
            }
            if (min != Long.MAX_VALUE) {
                return min;
            }
        }
        throw new RuntimeException();
    }

    private static int next(int x) {
        int rightOne = x & -x;
        int nextHigherOneBit = x + rightOne;
        int rightOnesPattern = x ^ nextHigherOneBit;
        rightOnesPattern = (rightOnesPattern) / rightOne;
        rightOnesPattern >>= 2;
        return nextHigherOneBit | rightOnesPattern;
    }

    public Object solvePart1(List<String> input) {

        int[] sizes = input.stream().mapToInt(Integer::parseInt).toArray();
        return divide(sizes, 3);
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}