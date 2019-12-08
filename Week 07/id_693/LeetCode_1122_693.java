package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 1122. 数组的相对排序 https://leetcode-cn.com/problems/relative-sort-array/
 * @Date 2019/11/27
 */
public class LeetCode_1122_693 {
    /**
     * 计数排序：1、设定计数数组 2、放入计数数组 3、根据arr2取出计数数组数据，取出计数数组剩余的
     */
    class Solution {
        public int[] relativeSortArray(int[] arr1,int[] arr2) {
            int[] counts = new int[1001];
            int[] res = new int[arr1.length];
            for (int val : arr1) {
                counts[val]++;
            }
            int i = 0;
            for (int val : arr2) {
                while (counts[val]-- > 0) {
                    res[i++] = val;
                }
            }

            for (int j = 0; j < 1001; j++) {
                while (counts[j]-- > 0) {
                    res[i++] = j;
                }
            }
            return res;
        }
    }
}
