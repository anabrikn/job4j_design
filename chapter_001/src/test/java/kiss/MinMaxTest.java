package kiss;

import java.util.List;
import org.junit.Test;
import org.junit.Assert;

public class MinMaxTest {
    @Test
    public void testMaxNumber() {
        List<Integer> values = List.of(-100, 75, 1, -75, 100);
        Integer exp = 100;
        Integer result = new MinMax().max(values, (first, second) -> (first - second));
        Assert.assertEquals(exp, result);
    }

    @Test
    public void testMinNumber() {
        List<Integer> values = List.of(-100, 75, 1, -75, 100);
        Integer exp = -100;
        Integer result = new MinMax().min(values, (first, second) -> (first - second));
        Assert.assertEquals(exp, result);
    }

    @Test
    public void testFirstString() {
        List<String> values = List.of("aa", "aaaaa", "aaa", "aaaaa", "aaaaaaaaaa", "a");
        String exp = "a";
        String result = new MinMax().min(values, String::compareTo);
        Assert.assertEquals(exp, result);
    }

    @Test
    public void testLastString() {
        List<String> values = List.of("aa", "aaaaa", "aaa", "aaaaa", "aaaaaaaaaa", "a");
        String exp = "aaaaaaaaaa";
        String result = new MinMax().max(values, String::compareTo);
        Assert.assertEquals(exp, result);
    }
}
