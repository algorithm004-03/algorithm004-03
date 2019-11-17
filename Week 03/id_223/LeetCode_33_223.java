class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            }else if(target < nums[0] && target > nums[mid]) {
                left = mid + 1;
            }else right = mid;
        }
        return left == right && target == nums[left] ? left : -1; 
    }
}