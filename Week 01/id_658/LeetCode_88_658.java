/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 暴力解法 copy一个数组 然后双重遍历往里加 
        // 暴力的合并后排序
        // 双指针 从最大的元素往前加
        for (int l = m + n - 1, i = m - 1, j = n - 1; l >= 0; l--) {
            if (i < 0) {
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
                break;
            }
            if (j < 0) {
                break;
            }
            nums1[l] = (nums1[i] < nums2[j]) ? nums2[j--] : nums1[i--];
        }

    }
}
