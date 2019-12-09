package com.leetcode.kelvin;

/**
 * @author kelvin
 * @date 2019/10/19 7:18 PM
 */
public class RetateArray {
    public void rotateReverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateCircle(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int previous = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = previous;
                previous = temp;
                current = next;
                count++;
            } while (i != current);

        }
    }

    public void rotateVoilate(int[] nums, int k) {
        //暴力
        for (int i = 0; i < k; i++) {
            int previousValue = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previousValue;
                previousValue = temp;
            }

        }
    }
}
