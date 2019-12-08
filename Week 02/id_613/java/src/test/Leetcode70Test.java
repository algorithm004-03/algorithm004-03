import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class Leetcode70Test {
  @Test
  public void testSolutionOne1() {
    int n = 4;
    Leetcode70SolutionOne solution1 = new Leetcode70SolutionOne();
    Assertions.assertEquals(5, solution1.climbStairs(n));
  }

  @Test
  public void testSolutionOne2() {
    int n = 22;
    Leetcode70SolutionOne solution1 = new Leetcode70SolutionOne();
    Assertions.assertEquals(28657, solution1.climbStairs(n));
  }

  @Test
  public void testSolutionOne3() {
    int n = 1;
    Leetcode70SolutionOne solution1 = new Leetcode70SolutionOne();
    Assertions.assertEquals(1, solution1.climbStairs(n));
  }

  @Test
  public void testSolutionTwo1() {
    int n = 4;
    Leetcode70SolutionTwo solution2 = new Leetcode70SolutionTwo();
    Assertions.assertEquals(5, solution2.climbStairs(n));
  }

  @Test
  public void testSolutionTwo2() {
    int n = 22;
    Leetcode70SolutionTwo solution2 = new Leetcode70SolutionTwo();
    Assertions.assertEquals(28657, solution2.climbStairs(n));
  }

  @Test
  public void testSolutionTwo3() {
    int n = 1;
    Leetcode70SolutionTwo solution2 = new Leetcode70SolutionTwo();
    Assertions.assertEquals(1, solution2.climbStairs(n));
  }
}