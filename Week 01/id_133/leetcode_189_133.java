
//leetcode 题号189 旋转数组问题

import java.io.*;
import java.util.Arrays;

public class Solution {
    public int[] rotate(int[] nums, int k) {
        int currentNums,temp;
        for (int i = 1; i<= k; i++) {
            currentNums = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = currentNums;
                currentNums = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] targetBox = {1,1,2,3,3,5};//有序数组
        int k = 4;
        Solution solution =  new Solution();
        int result[] = solution.rotate(targetBox,k);
        System.out.println("输出：" + Arrays.toString(result));
    }
}