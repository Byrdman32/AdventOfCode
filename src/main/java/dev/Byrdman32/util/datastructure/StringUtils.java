package dev.Byrdman32.util.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static boolean containsAll(String first, String second) {
        for (var c : second.toCharArray()) {
            if (!first.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }

    public static boolean containsTimes(String first, String second, int times) {
        var count = 0L;
        for (var c : second.toCharArray()) {
            if (first.contains(String.valueOf(c))) {
                count++;
            }
        }

        return count == times;
    }

    public static List<String> sortStringsInList(List<String> in) {
        var sortedNewList = new ArrayList<String>();

        for (var digit : in) {
            var list = Arrays.stream(digit.split(""))
                    .sorted()
                    .toList();

            String sorted = String.join("", list);
            sortedNewList.add(sorted);
        }

        return sortedNewList;
    }
}