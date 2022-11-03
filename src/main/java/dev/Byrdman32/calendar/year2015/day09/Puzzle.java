package dev.Byrdman32.calendar.year2015.day09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private List<String> findCities(List<String> input) {
        List<String> allCities = new ArrayList<>();

        for (String line : input) {
            String start = line.substring(0, line.indexOf(" "));
            String end = line.substring(line.indexOf("to ") + 3, line.indexOf(" ="));

            allCities.add(start);
            allCities.add(end);
        }

        List<String> cities = new ArrayList<>(new HashSet<>(allCities));

        return cities;
    }

    public Object solvePart1(List<String> input) {

        List<String> cities = findCities(input);

        int[][] distances = new int[cities.size()][cities.size()];

        for (String line : input) {
            String start = line.substring(0, line.indexOf(" "));
            String end = line.substring(line.indexOf("to ") + 3, line.indexOf(" ="));
            int distance = Integer.parseInt(line.substring(line.indexOf("= ") + 2));

            int startCity = cities.indexOf(start);
            int endCity = cities.indexOf(end);

            distances[startCity][endCity] = distance;
            distances[endCity][startCity] = distance;
        }

        int shortestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < cities.size(); i++) {
            int distance = 0;
            int currentCity = i;
            int nextCity = 0;
            boolean[] visited = new boolean[cities.size()];
            visited[currentCity] = true;

            for (int j = 0; j < cities.size() - 1; j++) {
                int minDistance = Integer.MAX_VALUE;

                for (int k = 0; k < cities.size(); k++) {
                    if (!visited[k] && distances[currentCity][k] != 0 && distances[currentCity][k] < minDistance) {
                        minDistance = distances[currentCity][k];
                        nextCity = k;
                    }
                }

                distance += minDistance;
                visited[nextCity] = true;
                currentCity = nextCity;
            }

            if (distance < shortestDistance) {
                shortestDistance = distance;
            }
        }

        return shortestDistance;
    }

    public Object solvePart2(List<String> input) {

        List<String> cities = findCities(input);

        int[][] distances = new int[cities.size()][cities.size()];

        for (String line : input) {
            String start = line.substring(0, line.indexOf(" "));
            String end = line.substring(line.indexOf("to ") + 3, line.indexOf(" ="));
            int distance = Integer.parseInt(line.substring(line.indexOf("= ") + 2));

            int startCity = cities.indexOf(start);
            int endCity = cities.indexOf(end);

            distances[startCity][endCity] = distance;
            distances[endCity][startCity] = distance;
        }

        int longestDistance = 0;

        for (int i = 0; i < cities.size(); i++) {
            int distance = 0;
            int currentCity = i;
            int nextCity = 0;
            boolean[] visited = new boolean[cities.size()];
            visited[currentCity] = true;

            for (int j = 0; j < cities.size() - 1; j++) {
                int maxDistance = 0;

                for (int k = 0; k < cities.size(); k++) {
                    if (!visited[k] && distances[currentCity][k] != 0 && distances[currentCity][k] > maxDistance) {
                        maxDistance = distances[currentCity][k];
                        nextCity = k;
                    }
                }

                distance += maxDistance;
                visited[nextCity] = true;
                currentCity = nextCity;
            }

            if (distance > longestDistance) {
                longestDistance = distance;
            }
        }

        return longestDistance;
    }
}