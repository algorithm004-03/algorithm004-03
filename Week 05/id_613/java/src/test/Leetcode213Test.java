import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class Leetcode213Test {
  @Test
  public void testSolutionOne1() {
    int nums[] = new int[]{2, 3, 2};
    Leetcode213SolutionOne solution = new Leetcode213SolutionOne();
    assertEquals(solution.rob(nums), 3);
  }

  @Test
  public void testSolutionOne2() {
    int nums[] = new int[]{1, 2, 3, 1};
    Leetcode213SolutionOne solution = new Leetcode213SolutionOne();
    assertEquals(solution.rob(nums), 4);
  }

  @Test
  public void testSolutionOne3() {
    int nums[] = new int[]{1, 2, 1, 1};
    Leetcode213SolutionOne solution = new Leetcode213SolutionOne();
    assertEquals(solution.rob(nums), 3);
  }

  @Test
  public void testSolutionOne4() {
    int nums[] = new int[]{1, 1};
    Leetcode213SolutionOne solution = new Leetcode213SolutionOne();
    assertEquals(solution.rob(nums), 1);
  }
}

