/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author L
 *
 */
public class LeetCode_188_138 {
	/**
	 * 动态规划 ：
	 * for 状态1 in 状态1所有取值：
	 * 		for 状态2 in 状态2所有取值：
	 * 			for 状态3 in 状态3所有取值：
	 * 				dp[状态1][状态2][状态3] = 择优(选择1，选择2，.... 选择n)
	 * 
	 * //dp[n][k][s] 第一个是天数，第二个是允许交易的最大次数(1....k)，第三个是当前的持有状态(0=没有持有股票,1=持有股票)
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length == 0)
            return 0;
        if(k == 0)
            return 0;    
        int n = prices.length;
        if (k > n / 2) 
            return maxProfit_k_infi(prices);
        int[][][] dp = new int[n][k+1][2];
        for(int i=0; i<n;i++) {
        	for(int kk=k;kk>=1;kk--) {
        		if(i == 0) {//处理初始状态
        			dp[i][kk][0] = 0;
        			dp[i][kk][1] = -prices[i];
        			continue;
        		}
        		dp[i][kk][0] = Math.max(dp[i-1][kk][0], dp[i-1][kk][1]+prices[i]);//第i天未持有股票的最大获利
        		dp[i][kk][1] = Math.max(dp[i-1][kk][1], dp[i-1][kk-1][0]-prices[i]);//第i天持有股票的最大获利
        	}
        }
        return dp[n-1][k][0];
    }
	
	/**
	 * k 无穷大
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit_k_infi(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int n = prices.length;
	    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
	    for (int i = 0; i < n; i++) {
	        int temp = dp_i_0;
	        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
	        dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
	    }
	    return dp_i_0;
	}
	
	/**
	 * k=1 每天只允许1次交易
	 * @param prices
	 * @return
	 */
	public int maxProfit_k_1(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int n = prices.length;
		int[][] dp = new int[n][2];
		for(int i=0;i<n;i++) {
			if(i == 0) {
				dp[i][0] = 0;
				dp[i][1] = -prices[i];
				continue;
			}
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);//比较 第i-1天未持有股票 和 第i-1天持有股票 哪个获利大 
			dp[i][1] = Math.max(dp[i-1][1], -prices[i]);//比较 第i-1天持有股票且第i天也持有股票 和 第i-1天买入股票
			
		}
		return dp[n-1][0];
	}
}
