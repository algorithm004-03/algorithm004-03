class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size()-1;
        int mid=0;
        while(left<=right) {
            mid = left + (right - left)/2;
            if(nums[mid]<nums[max(0,mid-1)]) break;
            if(nums[mid]>=nums[left]&&nums[mid]>=nums[right]) {
                left = mid +1;
            } else {
                right = mid-1;
            }
        }
        return nums[mid];
    }
};
