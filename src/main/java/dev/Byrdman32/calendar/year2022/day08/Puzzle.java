package dev.Byrdman32.calendar.year2022.day08;

import java.awt.*;
import java.util.*;
import java.util.List;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle {
    public Object solvePart1(List<String> input) {

        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < input.get(i).length(); j++) {
                grid.get(i).add(Integer.parseInt(input.get(i).substring(j, j + 1)));
            }
        }

        int numOfVisibleTrees = 0;

        for (int i = 0; i < grid.size(); i++)
            for (int j = 0; j < grid.get(i).size(); j++) {

                //check if on edge
                if (i == 0 || i == grid.size() - 1 || j == 0 || j == grid.get(0).size() - 1) {
                    numOfVisibleTrees++;
                    continue;
                }

                //check top neighbor
                boolean cont = false;
                int x = i - 1;
                while (x >= 0) {
                    if (grid.get(x).get(j) >= grid.get(i).get(j)) {
                        cont = true;
                        break;
                    }

                    x--;
                }

                if (!cont) {
                    numOfVisibleTrees++;
                    continue;
                }

                //check bottom neighbor
                cont = false;
                x = i + 1;
                while (x <= grid.size() - 1) {
                    if (grid.get(x).get(j) >= grid.get(i).get(j)) {
                        cont = true;
                        break;
                    }

                    x++;
                }

                if (!cont) {
                    numOfVisibleTrees++;
                    continue;
                }


                //check left neighbor
                if (Collections.max(grid.get(i).subList(0, j)) < grid.get(i).get(j)) {
                    numOfVisibleTrees++;
                    continue;
                }

                //check right neighbor
                if (Collections.max(grid.get(i).subList(j + 1, grid.get(i).size())) < grid.get(i).get(j)) {
                    numOfVisibleTrees++;
                }

            }
        return numOfVisibleTrees;
    }

    public Object solvePart2(List<String> input) {

        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < input.get(i).length(); j++) {
                grid.get(i).add(Integer.parseInt(input.get(i).substring(j, j + 1)));
            }
        }

        int bestTreeScore = 1;

        for (int i = 0; i < grid.size(); i++)
            for (int j = 0; j < grid.get(i).size(); j++) {
                int curTreeScore = 1;
                //check if on edge
                if (i == 0 || i == grid.size() - 1 || j == 0 || j == grid.get(0).size() - 1) {
                    continue;
                }

                //check top neighbor
                int topAmount = 0;
                int x = i - 1;
                while (x >= 0) {
                    if (grid.get(x).get(j) >= grid.get(i).get(j)) {
                        topAmount++;
                        break;
                    }
                    topAmount++;
                    x--;
                }
                curTreeScore = curTreeScore * topAmount;


                //check bottom neigbor
                int bottomScore = 0;
                x = i + 1;
                while (x <= grid.size() - 1) {
                    if (grid.get(x).get(j) >= grid.get(i).get(j)) {
                        bottomScore++;
                        break;
                    }

                    bottomScore++;
                    x++;
                }

                curTreeScore = curTreeScore * bottomScore;


                //check left neighbor
                int leftScore = 0;
                x = j - 1;
                while (x >= 0) {
                    if (grid.get(i).get(x) >= grid.get(i).get(j)) {
                        leftScore++;
                        break;
                    }

                    leftScore++;
                    x--;
                }

                curTreeScore = curTreeScore * leftScore;
                //check right neighbor
                int rightScore = 0;
                x = j + 1;
                while (x <= grid.get(i).size() - 1) {
                    if (grid.get(i).get(x) >= grid.get(i).get(j)) {
                        rightScore++;
                        break;
                    }

                    rightScore++;
                    x++;
                }

                curTreeScore = curTreeScore * rightScore;
                if (curTreeScore > bestTreeScore)
                    bestTreeScore = curTreeScore;

            }

        return bestTreeScore;
    }
}