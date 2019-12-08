import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class Leetcode541Test {
  @Test
  public void testSolution1() {
    String s = "abcdefg";
    Leetcode541 so = new Leetcode541();

    assertEquals(so.reverseStr(s, 2), "bacdfeg");
  }

  @Test
  public void testSolution2() {
    String s = "a";
    Leetcode541 so = new Leetcode541();

    assertEquals(so.reverseStr(s, 2), "a");
  }
}

