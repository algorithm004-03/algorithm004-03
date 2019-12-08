/**
 * 爬楼梯，非递归解法
 * 爬到第n级台阶的方法，等于先爬到n-1级台阶 和 先爬到n-2级台阶 的方法之和
 * f(n) = f(n-1) + f(n-2)，本质上就是一个Fibonacci序列
 *
 * 时间复杂度O(n)，空间复杂度O(1)
 *
 * 执行用时 : * 0 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 33 MB * , 在所有 java 提交中击败了 * 72.58% * 的用户
 */
class Leetcode70SolutionOne {
  public int climbStairs(int n) {
    int result = 0;

    // 假设给定n是正整数
    if (n < 2) {
      return 1;
    }

    // Fibonacci: 1,1,2,3,5,8,13,21,34,55...
    // Fibonacci序列的第0项 f(0)
    int first = 1;
    // Fibonacci序列的第1项 f(1)
    int second = 1;

    for (int i = 2; i <= n; i++) {
      // f(n) = f(n-1) + f(n-2)
      result = first + second;
      first = second;
      second = result;
    }

    return result;
  }

  public static void main(String[] args) {
    Leetcode70SolutionOne solution1 = new Leetcode70SolutionOne();
    int result = solution1.climbStairs(20);
    System.out.println(result);
  }
}