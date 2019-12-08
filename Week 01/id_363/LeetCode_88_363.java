package com.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class SolutionMergeArray88 {


    @Test
    public void test1() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge1(nums1, m, nums2, n);
    }


    /**
     * 自己写
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( nums2 == null)  return;
        // 1. 吧nums1 中的数据像后移动m位
        System.arraycopy(nums1, 0, nums1, n , m);
        // 2. 循环nums1 和 num2 向nums1 中加数据
        int mi = n , ni = 0,i = 0;
        while (mi < m + n  && ni < n) {
            while(nums1[mi] < nums2[ni]) {
                nums1[i ++] = nums1[mi ++];
                if (mi == m + n ) {
                    break;
                }
            }
            while(mi < m + n && ni < n && nums1[mi] >= nums2[ni]) {
                nums1[i ++] = nums2[ni ++];
                if (ni == n) {
                    break;
                }
            }
        }
        while(mi < m + n) {
            nums1[i ++] = nums1[mi ++];
        }
        while(ni < n) {
            nums1[i ++] = nums2[ni ++];
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并+排序
     * 双指针：从前往后 复制一份新的nums1
     * 双指针：从后往前
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if ( nums2 == null)  return;
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if ( nums2 == null)  return;
        int[] nums1Copy = nums1.clone();
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < m && i2 < n) {
            nums1[i ++] = nums1Copy[i1] < nums2[i2] ? nums1Copy[i1 ++] : nums2[i2 ++];
        }
        if (i1 < m) {
            System.arraycopy(nums1Copy, i1, nums1, n + i1  , m - i1);
        }
        if (i2 < n) {
            System.arraycopy(nums2, i2, nums1, m + i2 , n - i2);
        }
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 最佳 best
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        if ( nums2 == null)  return;
        int i1 = m - 1, i2 = n - 1, i = m + n -1;
        while (i1 >= 0  && i2 >= 0) {
            nums1[i --] = nums1[i1] > nums2[i2] ? nums1[i1 --] : nums2[i2 --];
        }
        if (i2 >= 0) {
            System.arraycopy(nums2, 0,  nums1, 0, i2 + 1);
        }

        System.out.println(Arrays.toString(nums1));
    }
}
