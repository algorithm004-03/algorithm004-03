/**
 * Pow(x,n)
 *
 * 分治法
 *
 * 时间复杂度O(logn)，空间复杂度O(1)
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 99.92% * 的用户
 * 内存消耗 : * 33.5 MB * , 在所有 java 提交中击败了 * 73.59% * 的用户
 */
class Leetcode50SolutionOne {
  public double myPow(double x, int n) {
    // 处理边界条件
    if (n == 0) {
      return 1.0;
    }

    long ln = n;

    // 处理n为负数的情况
    if (ln < 0) {
      x = 1 / x;
      ln = ln * (-1);
    }

    return fastPow(x, ln);
  }

  private double fastPow(double x, long ln) {
    if (ln == 1) {
      return x;
    }

    double half = fastPow(x, ln / 2);
    return (ln % 2 == 0) ? half * half : half * half * x;
  }

  public static void main(String[] args) {
    Leetcode50SolutionOne solution = new Leetcode50SolutionOne();
    System.out.println(solution.myPow(2, 10));

  }
}