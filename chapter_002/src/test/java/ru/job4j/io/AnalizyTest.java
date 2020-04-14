package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.io.*;
import java.util.StringJoiner;

public class AnalizyTest {
    @Test
    public void whenUnavailable() throws IOException {
        Analizy a = new Analizy();
        a.unavailable("src/main/resources/sour.txt", "src/main/resources/target.txt");

        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (final BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/target.txt"))) {
            reader.lines().forEach(out::add);
        }

        String expected = "10:57:01;10:59:01"
                + System.lineSeparator()
                + "11:01:02;11:02:02";
        assertThat(out.toString(), is(expected));
    }
}