package dev.Byrdman32.calendar.year2015.day23;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static int run(List<String> program, int[] regs) {
        int pc = 0;
        for (; ; ) {
            if (pc < 0 || pc >= program.size()) {
                return regs[1];
            }
            String[] instr = program.get(pc).split(" ");
            switch (instr[0]) {
                case "inc":
                    regs[instr[1].charAt(0) - 'a']++;
                    pc++;
                    break;
                case "tpl":
                    regs[instr[1].charAt(0) - 'a'] *= 3;
                    pc++;
                    break;
                case "hlf":
                    regs[instr[1].charAt(0) - 'a'] /= 2;
                    pc++;
                    break;
                case "jio":
                    if (regs[instr[1].charAt(0) - 'a'] == 1) {
                        pc += Integer.parseInt(instr[2]);
                    } else {
                        pc++;
                    }
                    break;
                case "jie":
                    if ((regs[instr[1].charAt(0) - 'a'] & 1) == 0) {
                        pc += Integer.parseInt(instr[2]);
                    } else {
                        pc++;
                    }
                    break;
                case "jmp":
                    pc += Integer.parseInt(instr[1]);
                    break;
            }
        }
    }

    public Object solvePart1(List<String> input) {

        return run(input, new int[]{0, 0});
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}