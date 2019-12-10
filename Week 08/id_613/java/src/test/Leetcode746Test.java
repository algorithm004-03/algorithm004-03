import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class Leetcode746Test {
  @Test
  public void testSolution1() {
    Leetcode746 so = new Leetcode746();
    int[] cost = new int[]{10, 15, 20};
    assertEquals(15, so.minCostClimbingStairs(cost));
  }

  @Test
  public void testSolution2() {
    Leetcode746 so = new Leetcode746();
    int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    assertEquals(6, so.minCostClimbingStairs(cost));
  }
}
