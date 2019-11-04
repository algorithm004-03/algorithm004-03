class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (target == nums[mid]) return mid;
            else if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if (nums[0] > nums[mid] && target < nums[0] && target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}