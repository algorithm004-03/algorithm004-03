//322. 零钱兑换

//解法1： 动态规划
//思路：

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] func = new int[amount + 1];
        func[0] = 0;

        //func中自底而上存入1~amount的最小组合 func[amount + 1]即是result
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            //遍历所有硬币组合 获取最少的硬币组合
            for (int j = 0; j <coins.length; j++) {
                //如果当前金额数 - 当前硬币值 >= 0 则存在组合
                if (i - coins[j] >= 0) {
                    //若func中已经存在结果, 更新cost
                    if (func[i - coins[j]] != Integer.MAX_VALUE) {
                        cost = Math.min(cost, func[i - coins[j]] + 1);
                    }
                }
            }
            //func 存入当前最小组合value
            func[i] = cost;
        }
        return (func[amount] == Integer.MAX_VALUE) ? -1 : func[amount];
    }
}