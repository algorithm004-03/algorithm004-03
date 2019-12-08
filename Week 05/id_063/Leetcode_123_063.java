/*
动态规划递推思路

dp[i][j][0] 表示第i天已经完成j比交易手上没有持有股票状态下的最佳收益
dp[i][j][1] 表示第i天已经完成j比交易手上持有股票状态下的最佳收益

有如下递推关系

dp[i][j][0] = max (
    dp[i-1][j][0],                  // 前一天为止也没持有股票，交易次数也没变，今天什么都不做
    dp[i-1][j-1][1] + prices[i]     // 前一天为止有股票，交易次数少一次，今天卖股票
)

dp[i][j][1] = max (
    dp[i-1][j][1]                   // 前一天为止，持有股票，交易次数不变，今天什么都不做
    dp[i-1][j][0] - prices[i]       // 前一天为止，没股票，交易次数不变，今天买股票
)

其中j 只可能是0， 1， 2
最后答案是max(dp[n-1][0][0], dp[n-1][1][0], ..... dp[n-1][k][0])
(k是最多交易次数，这个问题里面k=2)

*/

import sun.jvm.hotspot.jdi.IntegerTypeImpl;

class Solution {
    class Node {
        long dp0;        // 没持有股票时候最大利润
        long dp1;        // 持有股票时候最大利润
    }

    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }

        final int MAX_SOLD_NUM = 2;
        Node[] dp_old = new Node[MAX_SOLD_NUM + 1];
        for (int i = 0; i <= MAX_SOLD_NUM; i++) {
            dp_old[i] = new Node();
        }

        Node[] dp_new = new Node[MAX_SOLD_NUM + 1];
        for (int i = 0; i <= MAX_SOLD_NUM ; i++) {
            dp_new[i] = new Node();
        }

        // 第一天的数据进行特殊初始化, 第一天不可能完成交易，因此dp[i][1][0:1] dp[i][2][0:1] ... dp[i][k][0:1]
        // 都是不存在的状态，利润设置为特殊值即可
        dp_old[0].dp0 = 0; dp_old[0].dp1 = -prices[0];
        for (int j = 1; j <= MAX_SOLD_NUM; j++) {
            dp_old[j].dp0 = dp_old[j].dp1 = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            dp_new[0].dp0 = dp_old[0].dp0;
            dp_new[0].dp1 = Math.max(dp_old[0].dp1, dp_old[0].dp0 - prices[i]);

            //System.out.print("(" + dp_new[0].dp0 + ", " + dp_new[0].dp1 + ")  ------");

            for (int j = 1; j <= MAX_SOLD_NUM; j++) {
                dp_new[j].dp0 = Math.max(dp_old[j].dp0, dp_old[j-1].dp1 + prices[i]);
                dp_new[j].dp1 = Math.max(dp_old[j].dp1, dp_old[j].dp0 - prices[i]);

                //System.out.print("(" + dp_new[j].dp0 + ", " + dp_new[j].dp1 + ")  ------");
            }

            //System.out.println();

            Node[] tmp = dp_new; dp_new = dp_old; dp_old = tmp;
        }

        int result = Integer.MIN_VALUE;
        for (int j = 0; j <= MAX_SOLD_NUM; j++) {
            result = (int)Math.max(result, dp_old[j].dp0);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {2, 1, 4}));
    }
}