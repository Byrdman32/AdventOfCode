package dev.Byrdman32.calendar.year2022.day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        Map<String, Integer> elfs = new HashMap<String, Integer>();
        int temp = 0;
        int elf = 1;

        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).isBlank()) {
                temp += Integer.parseInt(input.get(i));
            }

            if (input.get(i).isBlank() || i == input.size() - 1) {
//                System.out.println("Elf " + elf + " has " + temp + " calories.");
                elfs.put("Elf " + elf, temp);

                elf++;
                temp = 0;
            }
        }

        int max = 0;

        for (Map.Entry<String, Integer> entry : elfs.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        return max;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}