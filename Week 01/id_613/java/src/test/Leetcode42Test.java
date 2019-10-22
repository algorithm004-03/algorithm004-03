import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class Leetcode42Test {
  @Test
  // [0,1,0,2,1,0,1,3,2,1,2,1]
  public void testSolutionOne1() {
    int height[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    Leetcode42SolutionOne solution = new Leetcode42SolutionOne();
    int result = solution.trap(height);
    assertEquals(6, result);
  }

  @Test
  // [0,1,0,2,1,0,1,3,2,1,2,1]
  public void testSolutionTwo1() {
    int height[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    Leetcode42SolutionTwo solution = new Leetcode42SolutionTwo();
    int result = solution.trap(height);
    assertEquals(6, result);
  }
}
