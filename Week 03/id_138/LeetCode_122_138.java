/**
 * 	买卖股票的最佳时机II
 * 	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
	注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 * @author L
 *
 */
public class LeetCode_122_138 {
	/**
	 * 暴力法
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
        return maxProfitHelper(prices,0);
    }

	private int maxProfitHelper(int[] prices,int day) {
		// TODO Auto-generated method stub
		if(day>prices.length)
			return 0;
		int maxSum = 0;
		for(int start = day;start<prices.length;start++) {
			int maxProfit = 0;
			for(int i=start+1;i<prices.length;i++) {//计算所有可能交易可得的利润，找出利润最大的方法
				if(prices[i]>prices[start]) {
					int profit = maxProfitHelper(prices,i+1)+prices[i]-prices[start];
					if(profit > maxProfit) {
						maxProfit = profit;
					}
				}
			}
			if(maxProfit > maxSum) {
				maxSum = maxProfit;
			}
		}
		
		return maxSum;
	}
	
	/**
	 *  计算峰谷差值
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0){
            return 0;
        }
		int start = 0;
		int valley = prices[0];//低谷
		int peak = prices[0];//高峰
		
		int max = 0;
		while(start< (prices.length-1)) {
			while(start<prices.length-1 && prices[start]>=prices[start+1]) {//股票跌值
				start++;
			}
			valley = prices[start];
			while(start<prices.length-1 && prices[start] <= prices[start+1]) {//股票升值
				start++;
			}
			peak = prices[start];
			max += peak-valley;
		}
		return max;
	}
	
	/**
	 * 方法3
	 * @param prices
	 * @return
	 */
	public int maxProfitIII(int[] prices) {
		int sum = 0;
		for(int i=0;i<prices.length-1;i++) {
			if(prices[i+1]>prices[i]) {
				sum += prices[i+1]-prices[i];
			}
		}
		return sum;
	}
}
