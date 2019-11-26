import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class Leetcode33Test {
  @Test
  public void testSolutionOne1() {
    int nums[] = new int[]{4, 5, 6, 7, 0, 1, 2};
    Leetcode33SolutionOne solution = new Leetcode33SolutionOne();
    assertEquals(solution.search(nums, 0), 4);
  }

  @Test
  public void testSolutionOne2() {
    int nums[] = new int[]{4, 5, 6, 7, 0, 1, 2};
    Leetcode33SolutionOne solution = new Leetcode33SolutionOne();
    assertEquals(solution.search(nums, 3), -1);
  }

  @Test
  public void testBinarySearch1() {
    int nums[] = new int[]{0, 1, 2, 4, 5, 6, 7};
    Leetcode33SolutionOne solution = new Leetcode33SolutionOne();
    assertEquals(solution.binarySearch(nums, 0, nums.length - 1, 4), 3);
  }

  @Test
  public void testBinarySearch2() {
    int nums[] = new int[]{0};
    Leetcode33SolutionOne solution = new Leetcode33SolutionOne();
    assertEquals(solution.binarySearch(nums, 0, nums.length - 1, 4), -1);
  }
}
