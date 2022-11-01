package dev.Byrdman32.util.meta;

import lombok.SneakyThrows;

import java.util.List;
import java.util.function.Function;

import static java.lang.Math.round;
import static java.lang.System.nanoTime;

public class CommandLineTools {
    @SneakyThrows(value = Exception.class) // will never be thrown given a valid project structure
    public static <T, U> void log(Day day, Function<List<T>, U> toLog, List<T> input) {
        var result = time(toLog, input);
        System.out.printf("%s.%s: %s (-> took ~%sms [%sµs])\n",
                day.day(),
                day.part().ordinal() + 1,
                result.value,
                round(result.time / 100000.0) / 10d, // round to 2 decimal places
                result.time / 1000.0
        );
    }

    private static <T, U> Result<U> time(Function<List<T>, U> toTime, List<T> input) {
        var start = nanoTime();

        U result = toTime.apply(input);

        var end = nanoTime();
        var delta = (end - start);

        return new Result<>(delta, result);
    }

    public enum Part {
        FIRST, SECOND
    }

    public record Day(String day, Part part) {
    }

    private record Result<U>(Long time, U value) {
    }
}