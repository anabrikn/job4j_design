package ru.job4j.tdd.template;

import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    public void outputIfAllRight() {
        Generator generator = new PhraseGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        String exp = "I am a Kitty, Who are you? ";
        Map<String, Object> map = Map.of("name", "Kitty", "subject", "you");
        String result = generator.produce(pattern, map);
        assertTrue(result.equals(exp));
    }

    @Test (expected = RuntimeException.class)
    public void outputIfAllFalling() {
        Generator generator = new PhraseGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        Map<String, Object> map = Map.of("Kitty", "you");
        String result = generator.produce(pattern, map);
        String exp = "I am a Kitty, Who are you? ";
        assertTrue(result.equals(exp));
    }
}