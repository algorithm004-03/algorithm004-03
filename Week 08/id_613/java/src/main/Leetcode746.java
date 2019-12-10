/**
 * 使用最小花费爬楼梯
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 39.1 MB * , 在所有 java 提交中击败了 * 66.97% * 的用户
 */
public class Leetcode746 {
  // dp[i]为从第i级台阶出发的最小花费
  // DP方程：dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
  public int minCostClimbingStairs(int[] cost) {
    int[] re = new int[cost.length + 1];

    for (int i = 2; i < re.length; i++) {
      re[i] = Math.min(re[i - 1] + cost[i - 1], re[i - 2] + cost[i - 2]);
    }

    return re[re.length - 1];
  }

  public int climbingStairs(int n) {
    if (n < 2) {
      return n;
    }

    int[] re = new int[n];
    re[0] = 1;
    re[1] = 2;
    for (int i = 2; i < n; i++) {
      re[i] = re[i - 1] + re[i - 2];
    }

    return re[re.length - 1];
  }

  public static void main(String[] args) {
    Leetcode746 so = new Leetcode746();
    System.out.println(so.climbingStairs(3));

    int[] cost = new int[]{10, 15, 20};
    System.out.println(so.minCostClimbingStairs(cost));
  }
}
