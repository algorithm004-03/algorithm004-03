import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class Leetcode191Test {
  @Test
  public void testSolution1() {
    Leetcode191 solution = new Leetcode191();

    assertEquals(solution.hammingWeight(11), 3);
  }

  @Test
  public void testSolution2() {
    Leetcode191 solution = new Leetcode191();

    assertEquals(solution.hammingWeight(-3), 31);
  }
}

