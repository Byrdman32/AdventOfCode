package dev.Byrdman32.calendar.year2022.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    class Instruction {
        private Integer quantity;
        private Integer start;
        private Integer end;

        public Instruction(Integer quantity, Integer start, Integer end) {
            this.quantity = quantity;
            this.start = start;
            this.end = end;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }
    }

    public Object solvePart1(List<String> input) {

        ArrayList<Instruction> instructions = new ArrayList<>();
        List<List<Character>> crates = new ArrayList<>(9);
        List<Integer> crateCapacities = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            crates.add(new ArrayList<>(20));
            crateCapacities.add(0);
        }

        for (String line : input) {
            if (line.contains("move")) {
                String[] split = line.split(" ");
                Integer quantity = Integer.parseInt(split[1]);
                Integer start = Integer.parseInt(split[3]);
                Integer end = Integer.parseInt(split[5]);
                instructions.add(new Instruction(quantity, start, end));
            } else {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '[') {
                        crates.get((i / 4)).add(line.charAt(i + 1));
                        crateCapacities.set((i / 4), crateCapacities.get((i / 4)) + 1);
                    }
                }
            }
        }

        for (Instruction instruction : instructions) {
            List<Character> startCrate = crates.get(instruction.getStart() - 1);
            List<Character> endCrate = crates.get(instruction.getEnd() - 1);
            List<Character> newStartCrate = new ArrayList<>();

            for (int i = 0; i < startCrate.size(); i++) {
                if (i < instruction.getQuantity()) {
                    endCrate.add(0, startCrate.get(i));
                } else {
                    newStartCrate.add(startCrate.get(i));

                }
            }

            crates.set(instruction.getStart() - 1, newStartCrate);
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            if (!(crateCapacities.get(i) == 0)) {
                output.append(crates.get(i).get(0));
            }
        }

        return output.toString();
    }

    public Object solvePart2(List<String> input) {

        ArrayList<Instruction> instructions = new ArrayList<>();
        List<List<Character>> crates = new ArrayList<>(9);
        List<Integer> crateCapacities = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            crates.add(new ArrayList<>(20));
            crateCapacities.add(0);
        }

        for (String line : input) {
            if (line.contains("move")) {
                String[] split = line.split(" ");
                Integer quantity = Integer.parseInt(split[1]);
                Integer start = Integer.parseInt(split[3]);
                Integer end = Integer.parseInt(split[5]);
                instructions.add(new Instruction(quantity, start, end));
            } else {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '[') {
                        crates.get((i / 4)).add(line.charAt(i + 1));
                        crateCapacities.set((i / 4), crateCapacities.get((i / 4)) + 1);
                    }
                }
            }
        }

        for (Instruction instruction : instructions) {
            List<Character> startCrate = crates.get(instruction.getStart() - 1);
            List<Character> endCrate = crates.get(instruction.getEnd() - 1);
            List<Character> newStartCrate = new ArrayList<>();
            int counter = 0;

            for (int i = 0; i < startCrate.size(); i++) {
                if (i < instruction.getQuantity()) {
                    endCrate.add(counter, startCrate.get(i));
                    counter++;
                } else {
                    newStartCrate.add(startCrate.get(i));

                }
            }

            crates.set(instruction.getStart() - 1, newStartCrate);
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            if (!(crateCapacities.get(i) == 0)) {
                output.append(crates.get(i).get(0));
            }
        }

        return output.toString();
    }
}