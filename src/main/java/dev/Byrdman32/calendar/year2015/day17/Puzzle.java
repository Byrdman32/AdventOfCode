package dev.Byrdman32.calendar.year2015.day17;

import java.util.List;
import java.util.stream.IntStream;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    public Object solvePart1(List<String> input) {

        int[] buckets = input.stream().mapToInt(Integer::parseInt).toArray();
        int target = 150;

        int[] bitCounts = IntStream.range(1, 1 << buckets.length).filter(a ->
                IntStream.range(0, buckets.length).map(b -> ((a & (1 << b)) != 0) ? buckets[b] : 0).sum() == target
        ).map(Integer::bitCount).toArray();

        return bitCounts.length;
    }

    public Object solvePart2(List<String> input) {

        int[] buckets = input.stream().mapToInt(Integer::parseInt).toArray();
        int target = 150;

        int[] bitCounts = IntStream.range(1, 1 << buckets.length).filter(a ->
                IntStream.range(0, buckets.length).map(b -> ((a & (1 << b)) != 0) ? buckets[b] : 0).sum() == target
        ).map(Integer::bitCount).toArray();

        int minBits = IntStream.of(bitCounts).min().orElse(0);
        return IntStream.of(bitCounts).filter(i -> i == minBits).count();
    }
}