package dev.Byrdman32.calendar.year2015.day07;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private int indexOfWireB(List<String> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).substring(instructions.get(i).indexOf('>') + 2).equals("b")) {
                return i;
            }
        }

        return -1;
    }

    // recursively calculates all signals
    private void calculateSignal(String targetWire, String instr, List<String> instructions,
                                 Map<String, Integer> wireMapping, Pattern paramPattern) {

        // already calculated
        if (wireMapping.containsKey(targetWire)) {
            return;
        }

        // get the left-hand parameter(s)
        Matcher m = paramPattern.matcher(instr);
        List<String> params = params(instr, m);

        // base case
        if (params.size() == 1 && params.get(0).matches("\\d+")) {
            wireMapping.put(targetWire, Integer.parseInt(params.get(0)));
            return;
        }

        for (String param : params) {
            // parameter is a wire
            if (!param.matches("\\d+")) {
                String target = instructions.stream().filter(s -> s.substring(s.indexOf('>') + 2).equals(param))
                        .findFirst().get();
                if (!wireMapping.containsKey(param))
                    calculateSignal(param, target.substring(0, target.indexOf('-') - 1), instructions, wireMapping,
                            paramPattern);
                // parameter is an integer literal
            } else {
                wireMapping.put(param, Integer.parseInt(param));
            }
        }

        // calculate signal for this wire
        if (instr.contains("AND")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) & wireMapping.get(params.get(1)));
        } else if (instr.contains("OR")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) | wireMapping.get(params.get(1)));
        } else if (instr.contains("NOT")) {
            wireMapping.put(targetWire, ~wireMapping.get(params.get(0)) & 0xFFFF);
        } else if (instr.contains("LSHI")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) << wireMapping.get(params.get(1)));
        } else if (instr.contains("RSHI")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) >> wireMapping.get(params.get(1)));
        } else {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)));
        }
    }

    // returns the left-hand parameters of the instruction
    private List<String> params(String instr, Matcher m) {
        List<String> params = new ArrayList<>();
        while (m.find()) {
            params.add(m.group());
        }
        return params;
    }
    public Object solvePart1(List<String> input) {

        Map<String, Integer> wireMapping = new HashMap<>();
        // pattern to match left hand arguments
        Pattern p = Pattern.compile("[a-z]+|\\d+");
        return getObject(p, input, wireMapping);
    }

    public Object solvePart2(List<String> input) {
        Map<String, Integer> wireMapping = new HashMap<>();
        // pattern to match left hand arguments
        Pattern p = Pattern.compile("[a-z]+|\\d+");
        for (String instr : input) {
            String targetWire = instr.substring(instr.indexOf('>') + 2);

            if (!wireMapping.containsKey(targetWire)) {
                calculateSignal(targetWire, instr.substring(0, instr.indexOf('-') - 1), input, wireMapping, p);
            }
        }

        List<String> instructionsPt2 = new ArrayList<>(input);
        int indexWB = indexOfWireB(instructionsPt2);
        int aPt1 = wireMapping.get("a");

        instructionsPt2.set(indexWB,
                aPt1 + " -> " + input.get(indexWB).substring(input.get(indexWB).indexOf('>') + 2));

        Map<String, Integer> wireMapping2 = new HashMap<>();
        return getObject(p, instructionsPt2, wireMapping2);
    }

    private Object getObject(Pattern p, List<String> instructionsPt2, Map<String, Integer> wireMapping2) {
        for (String instr : instructionsPt2) {
            String targetWire = instr.substring(instr.indexOf('>') + 2);

            if (!wireMapping2.containsKey(targetWire)) {
                calculateSignal(targetWire, instr.substring(0, instr.indexOf('-') - 1), instructionsPt2, wireMapping2, p);
            }
        }

        return wireMapping2.get("a");
    }
}