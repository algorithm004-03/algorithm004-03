class Solution {

	public int maxProfit(int[] prices) {
		// 是否有股票
		boolean hasStock = false;
		// 收益
		int profit = 0;
		// 买入的时间
		int buy = 0;

		// 从第一天开始要倒数第二天
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				// 明天要涨，没买则买入，买入了则不动
				if (hasStock) {
					continue;
				} else {
					buy = i;
					hasStock = true;
				}
			} else {
				// 明天要跌，卖掉股票
				if (hasStock) {
					profit += prices[i] - prices[buy];

					hasStock = false;
				}
			}
		}

		// 最后还有股票，则卖出
		if (hasStock) {
			profit += prices[prices.length - 1] - prices[buy];
		}

		return profit;
	}
}