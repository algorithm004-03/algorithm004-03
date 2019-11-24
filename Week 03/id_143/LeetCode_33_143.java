/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int mid = l + (h - l)/2 ;

            // 当后旋转发生在后段，且目标不可能在前段时。
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                l = mid + 1;
                // 当前段发生旋转时，且目标不可能在前段时。
            } else if (target > nums[mid] && target < nums[0]) {
                l = mid + 1;
            } else {//目标在前段
                h = mid;
            }


        }
        return l == h && nums[l] == target ? l : -1;
    }
}
// @lc code=end

