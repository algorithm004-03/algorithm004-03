/*
思路
整个数组左右对换，然后前k个左右对换对换，前k个后面的所有元素左右对换
 */

class Solution {
    public void rotate(int[] nums, int k) {
        if ((nums.length == 0) || (k == 0)) {
            return;
        }

        int tmp;

        k %= nums.length;
        for (int i = 0, j = nums.length-1; i < j; i++, j--) {
            tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
        }

        for (int i = 0, j = k-1; i < j; i++, j--) {
            tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
        }

        for (int i = k, j = nums.length-1; i < j; i++, j--) {
            tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
        }
    }
}