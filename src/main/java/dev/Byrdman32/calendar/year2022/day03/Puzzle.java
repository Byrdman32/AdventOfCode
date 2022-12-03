package dev.Byrdman32.calendar.year2022.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private int pointValue(char input) {
        int points = switch (input) {
            case 'a' -> 1;
            case 'b' -> 2;
            case 'c' -> 3;
            case 'd' -> 4;
            case 'e' -> 5;
            case 'f' -> 6;
            case 'g' -> 7;
            case 'h' -> 8;
            case 'i' -> 9;
            case 'j' -> 10;
            case 'k' -> 11;
            case 'l' -> 12;
            case 'm' -> 13;
            case 'n' -> 14;
            case 'o' -> 15;
            case 'p' -> 16;
            case 'q' -> 17;
            case 'r' -> 18;
            case 's' -> 19;
            case 't' -> 20;
            case 'u' -> 21;
            case 'v' -> 22;
            case 'w' -> 23;
            case 'x' -> 24;
            case 'y' -> 25;
            case 'z' -> 26;
            case 'A' -> 27;
            case 'B' -> 28;
            case 'C' -> 29;
            case 'D' -> 30;
            case 'E' -> 31;
            case 'F' -> 32;
            case 'G' -> 33;
            case 'H' -> 34;
            case 'I' -> 35;
            case 'J' -> 36;
            case 'K' -> 37;
            case 'L' -> 38;
            case 'M' -> 39;
            case 'N' -> 40;
            case 'O' -> 41;
            case 'P' -> 42;
            case 'Q' -> 43;
            case 'R' -> 44;
            case 'S' -> 45;
            case 'T' -> 46;
            case 'U' -> 47;
            case 'V' -> 48;
            case 'W' -> 49;
            case 'X' -> 50;
            case 'Y' -> 51;
            case 'Z' -> 52;
            default -> 0;
        };

        return points;
    }

    public Object solvePart1(List<String> input) {

        int total = 0;

        for (String line : input) {
            int half = line.length() % 2 == 0 ? line.length() / 2 : line.length() / 2 + 1;
            String one = line.substring(0, half);
            String two = line.substring(half);

            char[] first = one.toCharArray();
            char[] second = two.toCharArray();

            HashMap<Character,Integer> hMap = new HashMap<>();
            HashMap<Character,Integer> hMap2 = new HashMap<>();

            for (char c : first) {
                if (!hMap.containsKey(c)) {
                    hMap.put(c, 1);
                }
            }
            for (char c : second) {
                if (hMap.containsKey(c)) {
                    hMap2.put(c, 1);
                }
            }

            for (Map.Entry<Character, Integer> entry : hMap2.entrySet()) {
                total += pointValue(entry.getKey());
            }
        }

        return total;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}