package dev.Byrdman32.calendar.year2015.day19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        List<String> lines = new ArrayList<>();
        String molecule = "";

        for (String line : input) {
            if (line.contains("=>")) {
                lines.add(line);
            } else if (!line.isBlank()) {
                molecule = line;
            }
        }

        Multimap<String, String> replacements = ArrayListMultimap.create();

        for(String line : lines){
            String[] parts = line.split(" => ");
            replacements.put(parts[0], parts[1]);
        }

        Set<String> newMolecules = new HashSet<>();
        for(String orig : replacements.keySet()){
            for(String repl : replacements.get(orig)){
                for(int i = 0; i <= molecule.length() - orig.length(); i++){
                    String mol = molecule.substring(i, i + orig.length());
                    if(mol.equals(orig)){
                        newMolecules.add(molecule.substring(0, i) + repl + molecule.substring(i + orig.length()));
                    }
                }
            }
        }

        return newMolecules.size();
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}