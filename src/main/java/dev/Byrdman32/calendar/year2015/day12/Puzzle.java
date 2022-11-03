package dev.Byrdman32.calendar.year2015.day12;

import java.util.ArrayList;
import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    public Object solvePart1(List<String> input) {

        int count = 0;
        String str = input.get(0);
        List<Integer> values = new ArrayList<>();
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-') {
                temp = temp.concat(str.charAt(i) + "");
            } else if (temp.length() > 0) {
                values.add(Integer.parseInt(temp));
                temp = "";
            }
        }

        for (Integer value : values) {
            count += value;
        }

        return count;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}