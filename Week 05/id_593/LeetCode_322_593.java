import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：
 * 暴力递归
 * 状态树 -> BFS
 * dp
 * a. 找重复性
 * f(n) = f(n - k) (n 到 k 累加之和)，类似 斐波那契数列 f(n) = f(n-1) + f(n-2) ，
 * 零钱兑换，就相当于，它能跳 不同的面额 的步数。
 * b. dp状态数组
 * f(n) = min{f(n-k), for k in [1, 2, 5]}) + 1 (我们是从中选取一枚硬币，所以+1)
 * c. dp方程
 *
 * @author jaryoung
 */
public class LeetCode_322_593 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        return coinChangeByRecursion(amount, coins, new int[amount]);
    }

    private int coinChangeByRecursion(int remain, int[] coins, int[] mono) {
        if (remain < 0) {
            return -1;
        }
        if (remain == 0) {
            return 0;
        }
        if (mono[remain - 1] != 0) {
            return mono[remain - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChangeByRecursion(remain - coin, coins, mono);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }
        mono[remain - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return mono[remain - 1];
    }

    public int coinChangeByDp(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int n = 1; n < max; n++) {
            for (int coin : coins) {
                if (coin <= n) {
                    dp[n] = Math.min(dp[n], dp[n - coin] + 1);
                }
            }
        }
        return dp[amount] != max ? dp[amount] : -1;
    }
}
