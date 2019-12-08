/**
 * 2的幂
 */
public class Leetcode231Two {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }

    // first, cal bit count
    int count = 0;
    while (n != 0) {
      count++;
      n = n & (n - 1);
    }

    return count == 1;
  }
}
