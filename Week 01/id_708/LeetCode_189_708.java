class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}


// Brute force
class Solution2 {
    public void rotate(int[] nums, int k) {
        while (k-- > 0) {
            // one rotation at a time
            int prev = nums[nums.length-1];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i]; 
                nums[i] = prev;
                prev = temp;
            }
        }
    }
}