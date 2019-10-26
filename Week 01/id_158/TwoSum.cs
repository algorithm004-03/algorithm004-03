/*
 * @lc app=leetcode.cn id=1 lang=csharp
 *
 * [1] 两数之和
 */

// @lc code=start
using System.Collections.Generic;

public class Solution {

    // 暴力法
    public int[] TwoSumForce(int[] nums, int target) {

        for (int i = 0; i < nums.Length; i++)
        {
            for (int j = i+1; j < nums.Length; j++)
            {
                if (nums[i]+nums[j]==target) {
                    return new int[2]{i,j};
                }
            }
        }
        return new int[0];
    }
    // 空间换时间
    public int[] TwoSum(int[] nums, int target) {

        Dictionary<int,int> dict = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            int remainder = target - nums[i];
            if(dict.ContainsKey(remainder) && dict[remainder]!=i){
                return new int[2]{dict[remainder], i};
            } else {
                if(!dict.ContainsKey(nums[i]))
                  dict.Add(nums[i],i);
            }
        }
        return new int[0];
    }
}
// @lc code=end