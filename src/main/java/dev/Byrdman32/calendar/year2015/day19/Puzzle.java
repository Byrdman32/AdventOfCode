package dev.Byrdman32.calendar.year2015.day19;

import java.util.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static Collection<String> doReplacement(String original, Multimap<String, String> replacements){
        Set<String> replaced = new HashSet<>();
        for(String orig : replacements.keySet()){
            for(String repl : replacements.get(orig)){
                int index = 0;
                while((index = original.indexOf(repl, index)) != -1){
                    replaced.add(original.substring(0, index) + orig + original.substring(index + repl.length()));
                    index++;
                }
            }
        }

        return replaced;
    }

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

        Integer depth = 0;

        Set<String> currLevel = new HashSet<>();
        currLevel.add(molecule);

        Set<String> prevSeen = new HashSet<>();
        prevSeen.add(molecule);

        while(!currLevel.contains("e") && !currLevel.isEmpty()){
            depth++;
            Set<String> nextLevel = new HashSet<>();
            for(String c : currLevel){
                nextLevel.addAll(doReplacement(c, replacements));
            }

            nextLevel.removeAll(prevSeen);
            prevSeen.addAll(nextLevel);

            Set<String> sortedNextLevel = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String key1, String key2) {
                    if(key1.length() >= key2.length()){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            sortedNextLevel.addAll(nextLevel);

            currLevel = new HashSet<>();
            Iterator<String> iter = sortedNextLevel.iterator();
            while(iter.hasNext() && currLevel.size() <= 10){
                currLevel.add(iter.next());
            }
        }

        return depth;
    }
}