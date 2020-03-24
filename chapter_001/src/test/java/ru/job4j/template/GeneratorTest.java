package ru.job4j.template;

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

    @Test
    public void outputIfAllFalling() throws RuntimeException {
        Generator generator = new PhraseGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        Map<String, Object> map = Map.of("Kitty", "you");
        try {
            String result = generator.produce(pattern, map);
            fail();
        } catch (RuntimeException e) {
            assertNotEquals("", e.getMessage());
        }
    }
/*
    @Test
public void thisShouldFailIfExceptionCaught() {
    //Given...
    try {
        // When...
    } catch (Exception e) {
        Assert.fail();
    }
    // Then...
}

@Test
public void thisShouldPassOnlyIfTheExceptionIsCaught() {
    //Given...
    try {
        // When...
        Assert.fail();
    } catch (Exception expected) {}
    // No "then" needed, the fact that it didn't fail is enough.
}

@Test
public void irrelevantExceptionThatCouldBeThrown() {
    //Given...
    try {
        // When...
    } catch (Exception e) {}
    // Then...
}
     */
}