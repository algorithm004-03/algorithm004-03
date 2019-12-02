import java.util.Arrays;

/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @author L
 *
 */
public class LeetCode_322_138 {
	/**
	 * 递归-动态规划-自上往下
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange_solution1(int[] coins, int amount) {
		if(amount <=0) {
			return 0;
		}
		
		return coinChangeHelper(coins, amount, new int[amount]);
    }
	
	private int coinChangeHelper(int[] coins, int amount,int[] count) {
		if (amount < 0)
			return -1;
		if(amount == 0) {
			return 0;
		}
		//最终结果
		if(count[amount-1] != 0)
			return count[amount-1];
		
		int min = Integer.MAX_VALUE;
		for(int coin : coins) {
			int rs = coinChangeHelper(coins, amount-coin, count);
			if(rs >= 0 && rs < min) {
				min = rs+1;
			}
		}
		count[amount-1] = (min == Integer.MAX_VALUE?-1:min);
		return count[amount-1];
	}
	
	/**
	 * 动态规划-从下到上
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange_solution2(int[] coins, int amount) {
		if(amount <=0) {
			return 0;
		}
		int[] dp = new int[amount+1];
		dp[0] = 0;
		final int max = Integer.MAX_VALUE;
		for(int i=1;i <= amount;i++) {
			int cost = max;
			
			for(int j=0;j<coins.length;j++) {
				if(coins[j] <= i) {
					if(dp[i-coins[j]] != max) {
						cost = Math.min(cost, dp[i-coins[j]]+1);
					}
				}
			}
			dp[i] = cost;
		}
		
		return dp[amount] == max?-1:dp[amount];
    }
	
	
}
