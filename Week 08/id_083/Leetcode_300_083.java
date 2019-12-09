import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {

        //20191207
        //复杂度O(nlogn)
        int []dp = new int[nums.length];
        int len = 0;
        for(int x:nums){
            int i = Arrays.binarySearch(dp,0,len,x);
            if(i<0)
                i = -(i+1);
                dp[i] = x;
            if(i == len)
                len++;
        }
        return len;
    }
}
// @lc code=end

