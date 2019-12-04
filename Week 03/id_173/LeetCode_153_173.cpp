/*
 * 153. 寻找旋转排序数组中的最小值
 */

class Solution {
public:
    int findMin(vector<int>& nums) {
        int left=0, right=nums.size()-1;

        while(left < right) {
            if(nums[left] < nums[right])
                return nums[left];
            
            int mid = left+(right-left)/2;

            if(nums[mid] >= nums[left])
                left = mid+1;
            else
                right = mid;
        }

        return nums[left];
    }
};