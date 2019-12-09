package test1;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/10/20.
 */
public class Leetcode_88_638 {

    /**
     *合并两个有序数组
     * https://leetcode-cn.com/problems/merge-sorted-array/submissions/
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length - 1;
        int i = 0;
        while (i < n) {
            if (m == 0) {
                nums1[i] = nums2[i];
            } else if (m < n) {
                nums1[m + i] = nums2[i];
            } else {
                nums1[len - i] = nums2[i];
            }
            i++;
        }
        Arrays.sort(nums1);
    }


}
