class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0,  right = nums.size()-1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return target;
            else if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]) ||
                   nums[0] > nums[mid] && (target > nums[mid]) && target < nums[0]) {
                left = mid + 1;
            }
            else right = mid;
        }
        return left == right && nums[left] == target ? left : -1;
    }
};
