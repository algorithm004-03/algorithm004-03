package id_693;

import java.util.Arrays;

/**
 * @Desc 88.合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/20
 */
public class LeetCode_88_693 {

    public void merge(int[] nums1,int m,int[] nums2,int n) {
        for (int i = n + m - 1; i >= 0; i--) {
            if (m == 0) {
                nums1[i] = nums2[--n];
                continue;
            }
            if (n == 0) {
                nums1[i] = nums1[--m];
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
        }
    }

    //简化
    public void merge2(int[] nums1,int m,int[] nums2,int n) {
        //倒叙比较，水大放进去，然后自身下标-1，最后需要防止m和n的下表为0，所以就需要处理一下
        for (int i = n + m - 1; i >= 0; i--) {
            if (m == 0 || n == 0) {
                nums1[i] = m == 0 ? nums2[--n] : nums1[--m];
            } else {
                nums1[i] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
            }
        }
    }
    //最简解法
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        while (m != 0 && n != 0) nums1[m + n - 1] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        while (n != 0) nums1[m + n - 1] = nums2[--n];
    }

    public static void main(String[] args) {
        int[] m = new int[]{1,2,3,0,0,0};
        int[] n = new int[]{2,5,6};
        new LeetCode_88_693().merge2(m,3,n,3);
        System.out.println(Arrays.toString(m));
    }
}
