
/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 题号：300
 * 题目：最长上升子序列
 */

// 动态规划+二分查找

class Solution {
  public int lengthOfLIS(int[] nums) {
      int[] tails = new int[nums.length];
      int res = 0;
      for(int num : nums) {
          int i = 0, j = res;
          while(i < j) {
              int m = (i + j) / 2;
              if(tails[m] < num) i = m + 1;
              else j = m;
          }
          tails[i] = num;
          if(res == j) res++;
      }
      return res;
  }
}