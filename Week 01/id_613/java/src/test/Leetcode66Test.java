import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class Leetcode66Test {
  @Test
  // [1,1,2]
  public void testSolution1() {
    int nums[] = new int[]{1, 1, 2};
    Leetcode66SolutionOne solution = new Leetcode66SolutionOne();
    int[] result = solution.plusOne(nums);

    assertArrayEquals(new int[]{1, 1, 3}, result);
  }

  @Test
  // [0]
  public void testSolution2() {
    int nums[] = new int[]{0};
    Leetcode66SolutionOne solution = new Leetcode66SolutionOne();
    int[] result = solution.plusOne(nums);

    assertArrayEquals(new int[]{1}, result);
  }

  @Test
  // [9,9,9]
  public void testSolution3() {
    int nums[] = new int[]{9, 9, 9};
    Leetcode66SolutionOne solution = new Leetcode66SolutionOne();
    int[] result = solution.plusOne(nums);

    assertArrayEquals(new int[]{1, 0, 0, 0}, result);
  }

  @Test
  // [9,8,7,6,5,4,3,2,1,0]
  public void testSolution4() {
    int nums[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    Leetcode66SolutionOne solution = new Leetcode66SolutionOne();
    int[] result = solution.plusOne(nums);

    assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}, result);
  }

  @Test
  // [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]
  public void testSolution5() {
    int nums[] = new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8,
            4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
    Leetcode66SolutionOne solution = new Leetcode66SolutionOne();
    int[] result = solution.plusOne(nums);

    assertArrayEquals(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8,
            4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 7}, result);
  }
}
