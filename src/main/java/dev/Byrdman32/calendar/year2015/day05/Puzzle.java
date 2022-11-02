package dev.Byrdman32.calendar.year2015.day05;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int count = 0;

        for (String s : input) {
            if (
                !(s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy")) &&
                !(s.length() < 3) &&
                  s.matches(".*[aeiou].*[aeiou].*[aeiou].*") && s.matches(".*(.)\\1.*")
            ) {
                count++;
            }
        }

        return count;
    }

    public Object solvePart2(List<String> input) {

        int count = 0;

        for (String s : input) {
            if (
                s.matches(".*(.).\\1.*") && s.matches(".*(..).*\\1.*")
            ) {
                count++;
            }
        }

        return count;
    }
}