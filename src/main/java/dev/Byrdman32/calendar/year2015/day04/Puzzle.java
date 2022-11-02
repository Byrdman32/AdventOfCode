package dev.Byrdman32.calendar.year2015.day04;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Puzzle implements GenericPuzzle  {

    private static final ThreadLocal<MessageDigest> TL_MD5 = ThreadLocal.withInitial(() -> {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    });

    private static int parallelFirstWithStart(String start, String input) {
        return IntStream.iterate(0, i -> i + 1).parallel().filter(i -> startsWith(input, i, start)).findFirst()
                .orElseThrow();
    }

    private static boolean startsWith(String key, int i, String target) {
        return toMd5String(key + i).startsWith(target);
    }

    private static String toMd5String(String combined) {
        return String.format("%032x",
                new BigInteger(1, TL_MD5.get().digest(combined.getBytes(StandardCharsets.UTF_8))));
    }
    public Object solvePart1(List<String> input) {

        return parallelFirstWithStart("00000", input.get(0));
    }

    public Object solvePart2(List<String> input) {

        return parallelFirstWithStart("000000", input.get(0));
    }
}