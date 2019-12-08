public class LeetCode_121_368 {

    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock*/

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > max) {
                    max = prices[i] - minPrice;
                }
            }
        }
        return max;
    }
}
