class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int p = 1; // index of the last non-repeating element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[p++] = nums[i];
                count++;
            }
        }
        return count;
    }
}