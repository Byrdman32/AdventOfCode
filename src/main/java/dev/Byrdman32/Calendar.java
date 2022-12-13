package dev.Byrdman32;

import dev.Byrdman32.annotation.ExecutedDays;
import dev.Byrdman32.interfaces.GenericPuzzle;
import dev.Byrdman32.util.meta.CommandLineTools;
import lombok.SneakyThrows;

import java.io.IOException;

import static com.google.common.reflect.ClassPath.from;
import static dev.Byrdman32.annotation.ExecutedDays.Day.*;
import static dev.Byrdman32.util.meta.CommandLineTools.Part.FIRST;
import static dev.Byrdman32.util.meta.CommandLineTools.Part.SECOND;
import static dev.Byrdman32.util.meta.CommandLineTools.log;
import static dev.Byrdman32.util.meta.File.read;
import static java.lang.Thread.currentThread;

@ExecutedDays(day = DAY_10)
public class Calendar {
    private static final String CURRENT_YEAR = "2022";

    @SuppressWarnings({"UnstableApiUsage", "unchecked"})
    @SneakyThrows(value = IOException.class)
    public static void main(String[] args) {
        System.out.printf("Solutions for Advent of Code %s", CURRENT_YEAR);
        var specificDay = parseAnnotation();

        from(currentThread().getContextClassLoader())
                .getTopLevelClasses()
                .stream()
                .filter(c -> c.getName().startsWith("dev.Byrdman32.calendar.year%s".formatted(CURRENT_YEAR)) && !c.getName().contains("refactored") && !c.getName().contains("models"))
                .filter(c -> "00".equals(specificDay) || c.getName().contains(specificDay))
                .forEach(clazz -> new InvokablePuzzle((Class<? extends GenericPuzzle>) clazz.load()).invoke());
    }

    public record InvokablePuzzle(Class<? extends GenericPuzzle> clazz) {
        @SneakyThrows
        void invoke() {
            var puzzle = clazz.getDeclaredConstructor().newInstance();
            var name = puzzle.getClass().getPackageName();
            var day = name.substring(name.length() - 2);

            System.out.printf("\nDay %s:\n", day);

            var input = read(CURRENT_YEAR, day);

            log(new CommandLineTools.Day(day, FIRST), puzzle::solvePart1, input);
            log(new CommandLineTools.Day(day, SECOND), puzzle::solvePart2, input);
        }
    }

    private static String parseAnnotation() {
        var annotation = Calendar.class.getAnnotation(ExecutedDays.class);
        return getDayRepresentation(annotation.day());
    }
}