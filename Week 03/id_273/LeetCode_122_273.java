//122. 买卖股票的最佳时机II

//解法1：贪心思想
//思路：若当天价格大于前一天的价格, 就进行买卖操作, 也就是获取差值总额
//时间复杂度O(n)
//空间复杂度O(1)
public int maxProfit(int[] prices) {
	int sum = 0;
	for (int i = 0; i < prices.length - 1; i++) {
		if (prices[i] < prices[i + 1]) sum += prices[i + 1] - prices[i];
	}
	return sum;
}