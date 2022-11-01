package dev.Byrdman32.util.meta;

import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static dev.Byrdman32.util.meta.Request.fetchInput;

public class File {
    @SneakyThrows(value = IOException.class)
    public static List<String> read(String year, String day) {
        var file = new java.io.File("src/main/java/dev/Byrdman32/calendar/year%s/day%s/input.txt".formatted(year, day));

        if (!file.exists()) {
            createFile(file, year, day);
        }

        return Files.lines(file.toPath()).toList();
    }

    public static String readFile(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    private static void createFile(java.io.File file, String year, String day) throws IOException {
        var fileSuccessfullyCreated = file.createNewFile();

        if (fileSuccessfullyCreated) {
            System.out.printf("File for day %s was successfully created.\n", day);
        }

        System.out.println("Fetching input and writing to file...");

        var input = fetchInput(year, day);
        var writer = new FileWriter(file);
        writer.write(input);
        writer.close();

        System.out.println("Done! Have fun hacking :)");
    }
}