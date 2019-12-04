package id_693;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc 300. 最长上升子序列	https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @Date 2019/12/04
 */
public class LeetCode_300_693 {
    /**
     * dp方程
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int[] dp = new int[len];
            Arrays.fill(dp,1);
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
                max = Math.max(dp[i],max);
            }
            return max;
        }
    }

    /**
     * 动态规划 + 二分
     */
    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int[] dp = new int[len];
            int res = 0;
            for (int num : nums) {
                int i = 0;
                int j = res;
                while (i < j) {
                    int m = i + (j - i) / 2;
                    if (dp[m] < num) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                dp[i] = num;
                if (j == res) {
                    res++;
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    @Test
    public void test2() {
        System.out.println(new Solution2().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
