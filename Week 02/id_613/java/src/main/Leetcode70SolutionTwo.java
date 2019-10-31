/**
 * 爬楼梯，递归解法
 * 爬到第n级台阶的方法，等于先爬到n-1级台阶 和 先爬到n-2级台阶 的方法之和
 * f(n) = f(n-1) + f(n-2)，本质上就是一个Fibonacci序列
 *
 * 时间复杂度O(2^n)，空间复杂度O(1)
 *
 * 超出时间限制
 */
class Leetcode70SolutionTwo {
  public int climbStairs(int n) {
    // 假设给定n是正整数
    if (n < 2) {
      return 1;
    }
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  public static void main(String[] args) {
    Leetcode70SolutionTwo solution2 = new Leetcode70SolutionTwo();
    int result = solution2.climbStairs(20);
    System.out.println(result);
  }
}