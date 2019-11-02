package id_693;

/**
 * @Desc 122. 买卖股票的最佳时机 II  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/02
 */
public class LeetCode_122_693 {
    //效率不是太好，贪心思路，看到明天的比现在好就买，但是容易出现后天的比明天的好。这样买卖交易有点多余了 O(N)时间复杂度
    public int maxProfit(int[] prices) {
        int spend = 0;
        int earn = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            //买
            if (i < prices.length - 1 && prices[i + 1] > price) {
                spend += price;
            }

            //卖
            if (i > 0 && price > prices[i - 1]) {
                earn += price - spend;
                spend = 0;
            }

        }
        return earn;
    }

    //网上思路，直接计算差值，然后就是赚的。每天都交易。有点不符合我的思维，时间复杂度O(n),但是比上面计算简单，真正效率高于上面
    public int maxProfit2(int[] prices) {
        int earn = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                earn += temp;
            }
        }
        return earn;
    }

    public int maxProfit3(int[] prices) {
        int earn = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                earn += prices[i] - prices[i - 1];
            }
        }
        return earn;
    }

    //官方的峰谷法，不错,这是最喜欢的，符合人类思维，第一个while找出前面的第一个可买的，然后在第二个一直找出相邻最高的值。漂亮
    public int maxProfit4(int[] prices) {
        int spend = 0;
        int earn = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            spend = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            earn += prices[i] - spend;
        }
        return earn;
    }
}
