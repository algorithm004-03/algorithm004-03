class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;
        if (k == 0) {
            return;
        }
        swap(nums, 0, nums.length - k -1);
        swap(nums, nums.length - k, nums.length -1);
        swap(nums, 0, nums.length -1);
    }

    private void swap(int [] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
