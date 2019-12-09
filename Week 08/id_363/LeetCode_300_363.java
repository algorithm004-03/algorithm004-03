package com.test.leetcode.week08;

import org.junit.Test;

import java.util.Arrays;


public class SolutionLongestIncreasingSub300 {


    /**
     * 题目：给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
     * @return
     */
    @Test
    public void test1() {
        System.out.println(lengthOfLIS(new int[]{2,2}));
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{3,2,1}));

        System.out.println(lengthOfLIS_2(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS_2(new int[]{2,2}));
        System.out.println(lengthOfLIS_2(new int[]{3,2,1}));
    }


    /**
     * 时间复杂度O(n ^ 2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // 创建数组 求第一个比当前值大的元素的下标
        int len = nums.length;
        // 从后想前循环nums
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = len - 2; i >= 0; i --) {
            // 比他大的元素 + 1
            int cur = nums[i];
            for (int j = i + 1; j < len ; j ++) {
                if (nums[j] > cur) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }


    /**
     * 贪心算法 + 二分查找
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int len = nums.length;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        // 如果比end值大, 那么直接加入到end中
        // 如果比end值小，那么替换tail中第一个大于等于num[i]的元素
        // 贪心:尽量让最终的有序数组都是最小值
        for (int i = 1; i < len; i ++) {
            if (nums[i] > tail[end]) {
                end ++;
                tail[end] = nums[i];
            } else {
                // 找到第一个>= nums[i] 的值 替换成 nums[i]
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end ++;
        return end;
    }


}
