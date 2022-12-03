package dev.Byrdman32.calendar.year2022.day01;

import java.util.*;

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

        Map<String, Integer> elfs = new HashMap<String, Integer>();
        int temp = 0;
        int elf = 1;

        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).isBlank()) {
                temp += Integer.parseInt(input.get(i));
            }

            if (input.get(i).isBlank() || i == input.size() - 1) {
                elfs.put("Elf " + elf, temp);

                elf++;
                temp = 0;
            }
        }

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : elfs.entrySet()) {
            list.add(entry.getValue());
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int num : list) {
            for (Map.Entry<String, Integer> entry : elfs.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        int max = 0;
        int count = 0;

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            if (count < 3) {
                max += entry.getValue();
            }

            count++;
        }

        return max;
    }
}