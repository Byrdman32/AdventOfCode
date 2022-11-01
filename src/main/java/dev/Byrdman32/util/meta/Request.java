package dev.Byrdman32.util.meta;

import com.google.common.io.CharStreams;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static dev.Byrdman32.util.meta.File.readFile;
import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;


class Request {
    private static final String REQUEST_URL = "https://adventofcode.com";
    private static final String SESSION_KEY = retrieveSessionKey();

    static String fetchInput(String year, String day) throws IOException {
        day = sanitizeDayForRequest(day);

        var url = new URL("%s/%s/day/%s/input".formatted(REQUEST_URL, year, day));
        var connection = url.openConnection();

        connection.setRequestProperty("Cookie", "session=%s".formatted(SESSION_KEY));

        return CharStreams.toString(new InputStreamReader(connection.getInputStream(), UTF_8));
    }

    @SneakyThrows
    private static String retrieveSessionKey() {
        return readFile("src/main/resources/secret.yml")
                .split(": ")[1]
                .replaceAll("\"", "")
                .trim();
    }

    private static String sanitizeDayForRequest(String day) {
        return String.valueOf(parseInt(day));
    }
}