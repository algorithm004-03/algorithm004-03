import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class Leetcode50Test {
  @Test
  public void testSolutionOne1() {
    Leetcode50SolutionOne solution = new Leetcode50SolutionOne();
    Assertions.assertEquals(1024.0, solution.myPow(2, 10));
  }

  @Test
  public void testSolutionOne2() {
    Leetcode50SolutionOne solution = new Leetcode50SolutionOne();
    Assertions.assertEquals(1.0, solution.myPow(2, 0));
  }

  @Test
  public void testSolutionOne3() {
    Leetcode50SolutionOne solution = new Leetcode50SolutionOne();
    Assertions.assertEquals(2.0, solution.myPow(2, 1));
  }

  @Test
  public void testSolutionOne4() {
    Leetcode50SolutionOne solution = new Leetcode50SolutionOne();
    Assertions.assertEquals(0.5, solution.myPow(2, -1));
  }

  @Test
  public void testSolutionOne5() {
    Leetcode50SolutionOne solution = new Leetcode50SolutionOne();
    Assertions.assertEquals(1.0, solution.myPow(1.0, -2147483648));
  }
}
