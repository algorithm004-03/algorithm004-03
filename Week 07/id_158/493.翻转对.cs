/*
 * @lc app=leetcode.cn id=493 lang=csharp
 *
 * [493] 翻转对
 */

// @lc code=start
using System;

public class Solution {
    public int ReversePairs(int[] nums) {
        return mergeSort(nums,0,nums.Length-1);
    }

    private int mergeSort(int[] nums,int left,int right){
        if(left>=right){
            return 0;
        }
        int mid = left + (right-left)>>2;
        int cnt = mergeSort(nums,left,mid) + mergeSort(nums,mid+1,right);
        for (int i = left,j=mid+1; i <= mid; i++)
        {
            while(j<=right && nums[i]/2.0 > nums[j]){
                j++;
            }
            cnt += j-(mid + 1) ;
        }
        Array.Sort(nums,left,right+1);
        return cnt;
    }
}
// @lc code=end

