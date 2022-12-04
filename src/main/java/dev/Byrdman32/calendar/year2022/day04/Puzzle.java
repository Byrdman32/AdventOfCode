package dev.Byrdman32.calendar.year2022.day04;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int totalOverlapping = 0;

        for (String line : input) {
            String[] split = line.split(",");
            int[] elf1 = new int[2];
            int[] elf2 = new int[2];

            elf1[0] = Integer.parseInt(split[0].split("-")[0]);
            elf1[1] = Integer.parseInt(split[0].split("-")[1]);
            elf2[0] = Integer.parseInt(split[1].split("-")[0]);
            elf2[1] = Integer.parseInt(split[1].split("-")[1]);

            if (elf1[0] <= elf2[0] && elf1[1] >= elf2[1]) {
                totalOverlapping++;
            } else if (elf2[0] <= elf1[0] && elf2[1] >= elf1[1]) {
                totalOverlapping++;
            }
        }

        return totalOverlapping;
    }

    public Object solvePart2(List<String> input) {

        int totalOverlapping = 0;

        for (String line : input) {
            String[] split = line.split(",");
            int[] elf1 = new int[2];
            int[] elf2 = new int[2];

            elf1[0] = Integer.parseInt(split[0].split("-")[0]);
            elf1[1] = Integer.parseInt(split[0].split("-")[1]);
            elf2[0] = Integer.parseInt(split[1].split("-")[0]);
            elf2[1] = Integer.parseInt(split[1].split("-")[1]);

            if (elf1[0] <= elf2[0] && elf1[1] >= elf2[0]) {
                totalOverlapping++;
            } else if (elf2[0] <= elf1[0] && elf2[1] >= elf1[0]) {
                totalOverlapping++;
            }
        }

        return totalOverlapping;
    }
}