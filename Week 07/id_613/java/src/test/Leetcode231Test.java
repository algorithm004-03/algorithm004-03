import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class Leetcode231Test {
  @Test
  public void testSolution1() {
    Leetcode231One solution = new Leetcode231One();

    assertTrue(solution.isPowerOfTwo(16));
    assertFalse(solution.isPowerOfTwo(218));
  }

  @Test
  public void testSolution2() {
    Leetcode231Two solution = new Leetcode231Two();

    assertTrue(solution.isPowerOfTwo(16));
    assertFalse(solution.isPowerOfTwo(218));
  }
}

