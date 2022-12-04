package dev.Byrdman32.calendar.year2015.day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        Map<String, Integer> ticker = new HashMap<>();
        ticker.put("children", 3);
        ticker.put("cats", 7);
        ticker.put("samoyeds", 2);
        ticker.put("pomeranians", 3);
        ticker.put("akitas", 0);
        ticker.put("vizslas", 0);
        ticker.put("goldfish", 5);
        ticker.put("trees", 3);
        ticker.put("cars", 2);
        ticker.put("perfumes", 1);

        for(String line : input) {
            String[] parts = line.split(" ", 3);
            String sue = parts[1].substring(0, parts[1].length() - 1);

            String[] properties = parts[2].split(",");
            boolean contender = true;
            for(String prop : properties) {
                String[] propParts = prop.split(": ");
                if (ticker.get(propParts[0].trim()) != Integer.parseInt(propParts[1].trim())) {
                    contender = false;
                    break;
                }
            }

            if (contender) {
                return sue;
            }
        }

        return null;
    }

    public Object solvePart2(List<String> input) {

        Map<String, Integer> ticker = new HashMap<>();
        ticker.put("children", 3);
        ticker.put("cats", 7);
        ticker.put("samoyeds", 2);
        ticker.put("pomeranians", 3);
        ticker.put("akitas", 0);
        ticker.put("vizslas", 0);
        ticker.put("goldfish", 5);
        ticker.put("trees", 3);
        ticker.put("cars", 2);
        ticker.put("perfumes", 1);

        for(String line : input){
            String[] parts = line.split(" ", 3);
            String sue = parts[1].substring(0, parts[1].length() - 1);

            String[] properties = parts[2].split(",");
            boolean contender = true;
            for (String prop : properties) {
                String[] propParts = prop.split(": ");
                String propertyName = propParts[0].trim();

                if ( propertyName.equalsIgnoreCase("cats") ||
                     propertyName.equalsIgnoreCase("trees")
                ) {
                    if (ticker.get(propertyName) >= Integer.parseInt(propParts[1].trim())) {
                        contender = false;
                        break;
                    }
                } else if ( propertyName.equalsIgnoreCase("pomeranians") ||
                            propertyName.equalsIgnoreCase("goldfish")
                ) {
                    if (ticker.get(propertyName) <= Integer.parseInt(propParts[1].trim())) {
                        contender = false;
                        break;
                    }
                } else {
                    if (ticker.get(propertyName) != Integer.parseInt(propParts[1].trim())) {
                        contender = false;
                        break;
                    }
                }
            }

            if (contender) {
                return sue;
            }
        }

        return null;
    }
}