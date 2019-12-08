package com.company.leetcode.editor.cn;
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_169 {

    //暴力求解
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        List<Integer> arr =  new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        Collections.sort(arr);
        int count = 1;
        int currentValue = (int) arr.get(0);
        for (int i = 1; i < arr.size(); i++) {

            if (count > n) {
                return currentValue;
            }

            if (arr.get(i) == currentValue) {
                count++;
                continue;
            }

            currentValue = arr.get(i);
            count = 1;
        }
        return currentValue;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int val = s.majorityElement(new int[]{-1,1,1,1,2,1});
//        System.out.println(val);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
