package dev.Byrdman32.util.converter;

import java.util.Arrays;
import java.util.List;

public class Input {
    /**
     * Re-reads the file (actually it doesn't -- it just works on the existing list --) and splits the list (aka input)
     * on a different delimiter than a newline (maybe a double newline on some day? \n\n)
     *
     * @return List<String> split on specified delimiter
     */
    public static List<String> splitOnDelimiter(List<String> input, String delimiter) {
        var inputFile = input.stream()
                .reduce("", (total, current) -> total += current)
                .split(delimiter);

        return Arrays.stream(inputFile).toList();
    }
}