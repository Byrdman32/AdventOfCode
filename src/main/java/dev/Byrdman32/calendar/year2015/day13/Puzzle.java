package dev.Byrdman32.calendar.year2015.day13;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Collections2;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static final Pattern HAPPINESS = Pattern.compile("([A-Za-z]+) would (gain|lose) (\\d+) happiness units by sitting next to ([A-Za-z]+)");

    public Object solvePart1(List<String> input) {

        Map<String, Integer> happinessGain = new HashMap<>();
        Set<String> names = new HashSet<>();

        for(String line : input){
            Matcher m = HAPPINESS.matcher(line);
            if(m.find()){
                happinessGain.put(m.group(1) + ":" + m.group(4), m.group(2).equals("gain") ? Integer.parseInt(m.group(3)) : -Integer.parseInt(m.group(3)));
                names.add(m.group(1));
            }else{
                System.err.println("Couldn't parse line: "+line);
            }
        }

        Integer maxHappiness = Integer.MIN_VALUE;

        Collection<List<String>> permutations = Collections2.permutations(names);
        for(List<String> perm : permutations){
            if(perm.size() != names.size())
                continue;

            Integer happiness = 0;
            for(int i = 0; i < perm.size() - 1; i++){
                happiness += happinessGain.get(perm.get(i) + ":" + perm.get(i + 1));
                happiness += happinessGain.get(perm.get(i + 1) + ":" + perm.get(i));
            }
            happiness += happinessGain.get(perm.get(0) + ":" + perm.get(perm.size() - 1));
            happiness += happinessGain.get(perm.get(perm.size() - 1) + ":" + perm.get(0));

            if(happiness > maxHappiness){
                maxHappiness = happiness;
            }
        }

        return maxHappiness;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}