import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class Leetcode1Test {
  @Test
  public void testSolutionOne1() {
    int nums[] = new int[]{2, 7, 11, 15};
    int target = 9;
    Leetcode1SolutionOne solution1 = new Leetcode1SolutionOne();
    int[] result = solution1.twoSum(nums, target);

    assertArrayEquals(new int[]{0, 1}, result);
  }
}
