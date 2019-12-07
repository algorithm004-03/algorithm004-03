/*
 * 33. 搜索旋转排序数组
 */

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left=0, right=nums.size()-1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(!((nums[0]<=nums[mid]) ^ (target<nums[0]) ^ (target>nums[mid])))
                left = mid + 1;
            else
                right = mid;
        }

        return (left==right && target==nums[left]) ? left : -1;
    }
};