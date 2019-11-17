/*
 * @lc app=leetcode id=153 lang=cpp
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
public:
    int findMin(vector<int>& nums) {
        //对于二分查找
        //1. 定义左边界和youbianjie
        int left  = 0;
        int right = nums.size() - 1;
        while(left < right)
        {
            //逼近left
            int mid = left  + (right - left)/2;
            if(nums[mid]>nums[right]) left =mid+1;
            else right = mid;
        }
        //因为升序排列。所以
        return nums[left];
    }
};
// @lc code=end

