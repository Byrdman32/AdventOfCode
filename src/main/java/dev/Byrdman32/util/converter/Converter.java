package dev.Byrdman32.util.converter;

import dev.Byrdman32.util.model.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    public static List<Long> longs(List<String> input) {
        return input.stream()
                .map(Long::parseLong)
                .toList();
    }

    /**
     * Returns a List of Pair<T>|s
     *
     * @param in List<T> any input of type 1,2,3,...
     * @return List<Pair < Long>> of type <1, 2>, <3,...>. The first element is ignored and will only be the first element for the second Pair
     */
    public static <T> List<Pair<T>> pairs(List<T> in) {
        var out = new ArrayList<Pair<T>>();
        for (int i = 1; i < in.size(); i++) {
            // prev, curr
            out.add(new Pair<T>(in.get(i - 1), in.get(i)));
        }

        return out;
    }

    /**
     * Combines neighboring elements of a List<T>
     *
     * @param step Stepsize (combine step elements to a new one)
     * @return new List<T>
     */
    public static List<Long> combine(List<Long> in, int step) {
        var out = new ArrayList<Long>();

        for (int i = 0; i < in.size() - step + 1; i++) {
            Long sum = 0L;
            for (int j = i; j < i + step; j++) {
                sum += in.get(j);
            }
            out.add(sum);
        }

        return out;
    }

    public static String flipBits(String in) {
        return Arrays.stream(in.split(""))
                .map(num -> num.equals("1") ? "0" : "1")
                .reduce("", (str, current) -> str += current);
    }
}