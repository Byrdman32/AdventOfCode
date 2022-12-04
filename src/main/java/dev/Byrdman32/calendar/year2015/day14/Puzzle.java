package dev.Byrdman32.calendar.year2015.day14;

import java.util.*;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    public class Reindeer
    {
        public String Name;
        public int TopSpeed;
        public int FlyTime;
        public int RestTime;

        public int DistanceTravelled;

        private int _remainingFlyTime;
        private int _remainingRestTime;

        public Reindeer(int topSpeed, int flyTime, int restTime, String name)
        {
            Name     = name;
            TopSpeed = topSpeed;
            FlyTime  = flyTime;
            RestTime = restTime;

            DistanceTravelled = 0;

            _remainingFlyTime = FlyTime;
            _remainingRestTime = 0;
        }

        /**
         * Moves the reindeer forward one second in time
         */
        public void moveForward()
        {
            if (_remainingFlyTime > 0)
            {
                DistanceTravelled += TopSpeed;
                _remainingFlyTime--;

                if (_remainingFlyTime == 0) _remainingRestTime = RestTime;
            }
            else if (_remainingRestTime > 0)
            {
                _remainingRestTime--;
                if (_remainingRestTime == 0) _remainingFlyTime = FlyTime;
            }
        }
    }
    public static int getMaximumPoints(List<Reindeer> reindeer, int raceDuration) {
        Map<String, Integer> points = new HashMap();
        for (Reindeer r : reindeer) points.put(r.Name, 0);

        for (int i = 0; i < raceDuration; i++) {
            moveReindeerForward(reindeer);

            int furtherDistance = reindeer.get(reindeer.size() - 1).DistanceTravelled;
            List<Reindeer> firstPlaceReindeer = new ArrayList(reindeer);

            for (int j = firstPlaceReindeer.size() - 1; j >= 0; j--) {
                if (firstPlaceReindeer.get(j).DistanceTravelled > furtherDistance) {
                    for (int k = firstPlaceReindeer.size() - 1; k > j; k--) {
                        firstPlaceReindeer.remove(k);
                    }

                    furtherDistance = firstPlaceReindeer.get(j).DistanceTravelled;
                }
                else if (firstPlaceReindeer.get(j).DistanceTravelled < furtherDistance) {
                    firstPlaceReindeer.remove(j);
                }
            }

            for (Reindeer r: firstPlaceReindeer) {
                points.put(r.Name, points.get(r.Name) + 1);
            }
        }

        return Collections.max(points.values());
    }

    public List<Reindeer> createReindeer(List<String> inputData) {
        List<Reindeer> reindeer = new ArrayList();

        for (String line : inputData)
        {
            String[] split = line.split(" ");

            String name  = split[0];
            int speed    = Integer.parseInt(split[3]);
            int flyTime  = Integer.parseInt(split[6]);
            int restTime = Integer.parseInt(split[13]);

            reindeer.add(new Reindeer(speed, flyTime, restTime, name));
        }

        return reindeer;
    }

    public static void moveReindeerForward(List<Reindeer> reindeer) {
        for (Reindeer r : reindeer) r.moveForward();
    }
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

        List<Reindeer> reindeer = createReindeer(input);

        return getMaximumPoints(reindeer, 2503);
    }
}