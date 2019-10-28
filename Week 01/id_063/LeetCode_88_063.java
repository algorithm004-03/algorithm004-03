/*
思路
两个数组都从右到左进行反向迭代，存储数据的位置初始设置在num1偏移两个数组长度和的位置
每次取两个数组当前迭代元素中较大的一个存放在num1的最末端，元素较大的那个数组迭代游标
左移，同时存储数据的位置进行左移

只要num1 和 num2两个数组中有一个先迭代完，循环就可以结束
这个时候出现两种情况
1. num1先迭代完  num2中还剩余一段内容，这段内容是现在所有数据中最小的，直接拷贝到num1开头位置
1. num2先迭代完  num1中前面剩一段是所有数据中最小的，且有序，本来就该存贮在现在的位置，不用做任何处理

整个过程扫描一遍即可结束 时间复杂度O(m+n) 空间复杂度O(1)    要换位思考，逆向迭代能够巧妙节省掉中间缓存

 */

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idxStore = m + n -1;
        int idx1 = m - 1;
        int idx2 = n - 1;

        while ((idx1 >= 0) && (idx2 >= 0)) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[idxStore--] = nums1[idx1--];
            } else {
                nums1[idxStore--] = nums2[idx2--];
            }
        }

        if (idx2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, idx2+1);
        }
    }
}