package com.test.leetcode;

import org.junit.Test;

import java.util.List;


public class SolutionRotateArray189 {


    @Test
    public void test1() {
        int[] arr = new int[]{1,2,3,4,5,6};
//        rotate( arr, 10);
        rotate3( arr, 2);
        System.out.println(arr);
    }

    /**
     * 旋转数组
     * 空间复杂度是O(k)
     * 1,2,3,4,5,6,7  k = 3
     * 5,6,7,1,2,3,4
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return;
        k = k % nums.length;
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }


    /**
     * 循环替换
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return;
        int len = nums.length;
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < len ; start ++) {
            int curIndex = start;
            int curValue = nums[start];
            do {
                int nextIndex = (curIndex + k) % len;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = curValue;
                curIndex = nextIndex;
                curValue = nextValue;
                count ++;
            } while (start != curIndex);
        }
    }


    /**
     * 翻转
     * @param nums
     * @param k
     */
    public void rotate3_best(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 1 || end <= start) return;
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start ++;
            end --;
        }
    }


}
