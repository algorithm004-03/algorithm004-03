package test1.Week8;

import java.util.Arrays;

public class LeetCode_746_638 {

    /**
     * 使用最小花费爬楼梯
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) return 0;

        int[] dp = cost;
        for (int i = 2;i < dp.length;i++){
            dp[i] = Math.min(dp[i-1] + cost[i],dp[i - 2] + cost[i]);
        }
        return Math.min(dp[dp.length - 1],dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        LeetCode_746_638 leetCode_746_638 = new LeetCode_746_638();
        int[] cost = {10,15,20};
        System.out.println(leetCode_746_638.minCostClimbingStairs(cost));;
    }
}
