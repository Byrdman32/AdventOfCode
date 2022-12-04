package dev.Byrdman32.calendar.year2015.day25;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

import static java.math.BigInteger.valueOf;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        String temp = input.get(0).split(" ")[16];
        String temp2 = input.get(0).split(" ")[18];

        int row = Integer.parseInt(temp.substring(0, temp.length() - 1));
        int col = Integer.parseInt(temp2.substring(0, temp2.length() - 1));

        return valueOf(252533).modPow(valueOf((long) (row + col - 2) * (row + col - 1) / 2 + col - 1),
                valueOf(33554393)).multiply(valueOf(20151125)).mod(valueOf(33554393)).intValue();
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}