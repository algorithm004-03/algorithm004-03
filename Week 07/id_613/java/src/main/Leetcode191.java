/**
 * 位1的个数
 */
public class Leetcode191 {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    // 边界条件
    if (n == 0) {
      return 0;
    }

    // 右移计算1的个数
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if (((n >> i) & 1) == 1) {
        count++;
      }
    }

    return count;
  }
}
