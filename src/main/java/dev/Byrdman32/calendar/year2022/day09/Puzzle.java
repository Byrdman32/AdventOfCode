package dev.Byrdman32.calendar.year2022.day09;

import java.util.List;
import java.util.HashSet;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {
    public Object solvePart1(List<String> input) {

        int headX = 0;
        int headY = 0;
        int tailX = 0;
        int tailY = 0;

        HashSet<String>positionsVisited = new HashSet<>();
        positionsVisited.add(0+","+0);

        for (String s : input) {
            int moveAmt = Integer.parseInt(s.split(" ")[1]);
            switch (s.split(" ")[0]) {
                case "L" -> {
                    for (int i = 0; i < moveAmt; i++) {
                        headX--;
                        if (Math.sqrt(Math.pow((headX - tailX), 2) + Math.pow(headY - tailY, 2)) > Math.sqrt(2)) {
                            tailX = headX + 1;
                            tailY = headY;
                            positionsVisited.add(tailX + "," + tailY);
                        }

                    }

                }
                case "R" -> {
                    for (int i = 0; i < moveAmt; i++) {
                        headX++;
                        if (Math.sqrt(Math.pow((headX - tailX), 2) + Math.pow(headY - tailY, 2)) > Math.sqrt(2)) {
                            tailX = headX - 1;
                            tailY = headY;
                            positionsVisited.add(tailX + "," + tailY);
                        }

                    }
                }
                case "U" -> {
                    for (int i = 0; i < moveAmt; i++) {
                        headY++;
                        if (Math.sqrt(Math.pow((headX - tailX), 2) + Math.pow(headY - tailY, 2)) > Math.sqrt(2)) {
                            tailY = headY - 1;
                            tailX = headX;
                            positionsVisited.add(tailX + "," + tailY);
                        }

                    }
                }
                case "D" -> {
                    for (int i = 0; i < moveAmt; i++) {
                        headY--;
                        if (Math.sqrt(Math.pow((headX - tailX), 2) + Math.pow(headY - tailY, 2)) > Math.sqrt(2)) {
                            tailY = headY + 1;
                            tailX = headX;
                            positionsVisited.add(tailX + "," + tailY);
                        }

                    }
                }
            }
        }

        return positionsVisited.size();
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}