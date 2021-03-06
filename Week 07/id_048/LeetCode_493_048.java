package com.leetcode.week07;

import java.util.Arrays;

/**
 * Created by tim on 2019/12/1.
 * 493 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

 你需要返回给定数组中的重要翻转对的数量
 示例 1:

 输入: [1,3,2,3,1]
 输出: 2
 示例 2:

 输入: [2,4,3,5,1]
 输出: 3
 注意:

 给定数组的长度不会超过50000。
 输入数组中的所有数字都在32位整数的表示范围内

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_493_048 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int  mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (left + right) >> 1; // (left + right) / 2
        int cnt = mergeSort(array,left,mid) + mergeSort(array,mid + 1, right);
//        merge(array,left,mid,right);
        for (int i=left,j=mid+1;i<=mid;i++) {
            while (j<=right && array[i]/2.0 > array[j]) {
                j++;
            }
            cnt += j-(mid+1);
        }
        Arrays.sort(array,left,right+1 );
        return cnt;
    }

    private void merge(int[] arr, int left, int mid ,int right) {
        int[] temp = new int[right-left+1];  //中间数组
        int i = left, j = mid+1 ,k=0;
        while (i<=mid && j<=right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j<=right) {
            temp[k++] = arr[j++];
        }
        for (int p=0;p<temp.length;p++) {
            arr[left+p] = temp[p];
        }
    }
}
