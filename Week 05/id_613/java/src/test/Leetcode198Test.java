import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class Leetcode198Test {
  @Test
  public void testSolutionOne1() {
    int nums[] = new int[]{1, 2, 3, 1};
    Leetcode198SolutionOne solution = new Leetcode198SolutionOne();
    assertEquals(solution.rob(nums), 4);
  }

  @Test
  public void testSolutionOne2() {
    int nums[] = new int[]{2, 1, 1, 2};
    Leetcode198SolutionOne solution = new Leetcode198SolutionOne();
    assertEquals(solution.rob(nums), 4);
  }
}

