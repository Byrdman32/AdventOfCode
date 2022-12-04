package dev.Byrdman32.calendar.year2015.day14;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int totalSeconds = 2503;
        int max = 0;
        int reindeerCount = input.size();

        int[][] reindeer = new int[reindeerCount][4];
        int[] distances = new int[reindeerCount];

        for (int i = 0; i < reindeerCount; i++) {
            String[] split = input.get(i).split(" ");
            reindeer[i][0] = Integer.parseInt(split[3]);
            reindeer[i][1] = Integer.parseInt(split[6]);
            reindeer[i][2] = Integer.parseInt(split[13]);
            reindeer[i][3] = Integer.parseInt(split[6]);

            int flyTime = 0;
            int counter = 0;

            while (counter < totalSeconds) {
                if (counter + reindeer[i][1] + reindeer[i][2] <= totalSeconds) {
                    flyTime += reindeer[i][1];
                    counter += reindeer[i][1] + reindeer[i][2];
                } else {
                    int remaining = totalSeconds - counter;

                    if (remaining > reindeer[i][1]) {
                        flyTime += reindeer[i][1];
                    } else {
                        flyTime += remaining;
                    }

                    counter += reindeer[i][1] + reindeer[i][2];
                }
            }

            distances[i] = (flyTime * reindeer[i][0]);
        }

        for (int j = 0; j < reindeerCount; j++) {
            if (distances[j] > max) {
                max = distances[j];
            }
        }

        return max;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}