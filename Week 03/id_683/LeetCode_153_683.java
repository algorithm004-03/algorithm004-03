class Solution {
    public int findMin(int[] nums) {
        if (nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (left == right) return nums[left];
        if (nums[right] > nums[0]) return nums[0];
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else if (nums[0] > nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}