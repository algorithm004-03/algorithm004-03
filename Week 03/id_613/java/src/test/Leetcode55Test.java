import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class Leetcode55Test {
  @Test
  public void testSolutionOne1() {
    int nums[] = new int[]{2, 3, 1, 1, 4};
    Leetcode55SolutionOne solution = new Leetcode55SolutionOne();
    solution.canJump(nums);
    assertEquals(solution.canJump(nums), true);
  }

  @Test
  public void testSolutionOne2() {
    int nums[] = new int[]{3, 2, 1, 0, 4};
    Leetcode55SolutionOne solution = new Leetcode55SolutionOne();
    solution.canJump(nums);
    assertEquals(solution.canJump(nums), false);
  }

  @Test
  public void testSolutionOne3() {
    int nums[] = new int[]{2, 0, 0};
    Leetcode55SolutionOne solution = new Leetcode55SolutionOne();
    solution.canJump(nums);
    assertEquals(solution.canJump(nums), true);
  }

  @Test
  public void testSolutionOne4() {
    int nums[] = new int[]{3, 2, 1, 0, 4};
    Leetcode55SolutionOne solution = new Leetcode55SolutionOne();
    solution.canJump(nums);
    assertEquals(solution.canJump(nums), false);
  }
}
