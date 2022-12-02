package dev.Byrdman32.calendar.year2022.day02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private int rockPaperScissors(Character player1, Character player2) {
        // 0 = tie
        // 1 = player1 wins
        // 2 = player2 wins

        // Rock -> A or X
        // Paper -> B or Y
        // Scissors -> C or Z

        if (player1 == 'A' && player2 == 'Z') {
            return 1;
        }
        if (player1 == 'C' && player2 == 'Y') {
            return 1;
        }
        if (player1 == 'B' && player2 == 'X') {
            return 1;
        }

        if (player1 == 'C' && player2 == 'X') {
            return 2;
        }
        if (player1 == 'B' && player2 == 'Z') {
            return 2;
        }
        if (player1 == 'A' && player2 == 'Y') {
            return 2;
        }

        return 0;
    }

    public Object solvePart1(List<String> input) {

        int total = 0;
        Map<String, Integer> pointValues = new HashMap<>();

        pointValues.put("Rock", 1);
        pointValues.put("Paper", 2);
        pointValues.put("Scissors", 3);
        pointValues.put("Lost", 0);
        pointValues.put("Tie", 3);
        pointValues.put("Won", 6);

        for (String line : input) {
            String[] split = line.split(" ");
            String player1 = split[0];
            String player2 = split[1];

            int result = rockPaperScissors(player1.charAt(0), player2.charAt(0));

            if (result == 0) {
                total += pointValues.get("Tie");
            } else if (result == 1) {
                total += pointValues.get("Lost");
            } else {
                total += pointValues.get("Won");
            }

            if (player2.charAt(0) == 'X') {
                total += pointValues.get("Rock");
            } else if (player2.charAt(0) == 'Y') {
                total += pointValues.get("Paper");
            } else if (player2.charAt(0) == 'Z') {
                total += pointValues.get("Scissors");
            }
        }

        return total;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}