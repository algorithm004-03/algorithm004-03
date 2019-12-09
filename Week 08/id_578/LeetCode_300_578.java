package com.hand.week8;

import java.util.Arrays;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/8
 */
public class LeetCode_300_578 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        int result = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
