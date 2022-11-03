package dev.Byrdman32.calendar.year2015.day10;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private int process(String input, int rounds) {
        String currentSeq = input;

        for (int i = 0; i < rounds; i++) {
            StringBuilder nextSeq = new StringBuilder();
            Character previousChar = null;
            int count = 1;
            for (char c : currentSeq.toCharArray()) {
                if (previousChar == null) {
                    previousChar = c;
                } else if (previousChar == c) {
                    count++;
                } else {
                    nextSeq.append(count);
                    nextSeq.append(previousChar);
                    previousChar = c;
                    count = 1;
                }
            }
            nextSeq.append(count);
            nextSeq.append(previousChar);

            currentSeq = nextSeq.toString();
        }

        return currentSeq.length();
    }

    public Object solvePart1(List<String> input) {

        return process(input.get(0), 40);
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}