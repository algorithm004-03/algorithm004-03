import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class Leetcode26Test {
  @Test
  public void testSolutionOne1() {
    int nums[] = new int[]{1, 1, 2};
    Leetcode26SolutionOne solution1 = new Leetcode26SolutionOne();
    int len = solution1.removeDuplicates(nums);

    int nums2[] = new int[len];
    System.arraycopy(nums, 0, nums2, 0, len);
    assertArrayEquals(new int[]{1, 2}, nums2);
  }

  @Test
  public void testSolutionOne2() {
    int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    Leetcode26SolutionOne solution1 = new Leetcode26SolutionOne();
    int len = solution1.removeDuplicates(nums);

    int nums2[] = new int[len];
    System.arraycopy(nums, 0, nums2, 0, len);
    assertArrayEquals(new int[]{0, 1, 2, 3, 4}, nums2);
  }

  @Test
  public void testSolutionTwo1() {
    int nums[] = new int[]{1, 1, 2};
    Leetcode26SolutionTwo solution2 = new Leetcode26SolutionTwo();
    int len = solution2.removeDuplicates(nums);

    int nums2[] = new int[len];
    System.arraycopy(nums, 0, nums2, 0, len);
    assertArrayEquals(new int[]{1, 2}, nums2);
  }

  @Test
  public void testSolutionTwo2() {
    int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    Leetcode26SolutionTwo solution2 = new Leetcode26SolutionTwo();
    int len = solution2.removeDuplicates(nums);

    int nums2[] = new int[len];
    System.arraycopy(nums, 0, nums2, 0, len);
    assertArrayEquals(new int[]{0, 1, 2, 3, 4}, nums2);
  }
}
