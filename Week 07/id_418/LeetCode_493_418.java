package com.ljg.leetcode.week07.a06;

/**
 * ReversePairs
 */
public class ReversePairs {

    public static void main(String[] args) {

        ReversePairs reversePairs = new ReversePairs();
        // int[] nums = new int[] { 1, 3, 2, 3, 1 };
        // int[] nums = new int[] { 2, 4, 3, 5, 1 };
        int[] nums = new int[] { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 };
        int count = reversePairs.reversePairs(nums);
        System.out.println("count:" + count);
        int i = 2147483647;
        int j = 2 * i;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("-1 >> 30 = " + (-1 >> 30));
        System.out.println("-1 >>> 30 = " + (-1 >>> 30));

        System.out.println("-4 >> 1 = " + (-4 >> 1));
        System.out.println("-4 >>> 1 = " + (-4 >>> 1));

        System.out.println("5 >> 1 = " + (5 >> 1));
        System.out.println("5 / 2.0 = " + (5 / 2.0));

    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int count = mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) >> 1;

        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        int len = nums.length;
        int[] arr = new int[len];

        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (nums[i] / 2.0 >  nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // 排序
        int index = start;
        i = start;
        j = mid + 1;
        while (i <= mid && j <= end) {
            arr[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) {
            arr[index++] = nums[i++];
        }
        while (j <= end) {
            arr[index++] = nums[j++];
        }

        for (int k = start; k <= end; k++) {
            nums[k] = arr[k];
        }

        return count;
    }
}