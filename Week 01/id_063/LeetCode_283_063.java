/*
    就是简单的数组移动操作
*/


public class Solution {
    public void moveZeroes(int[] nums) {
        int idx1, idx2;

        for (idx1 = 0, idx2 = 0; idx2 < nums.length; idx2++) {
            if (nums[idx2] != 0) {
                nums[idx1++] = nums[idx2];
            }
        }

        while (idx1 < nums.length) {
            nums[idx1++] = 0;
        }
    }
}
