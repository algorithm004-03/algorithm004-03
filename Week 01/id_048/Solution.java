package com.leetcode.practice;

/**
 * Created by tim on 2019/10/20.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] dits =  {1,2,3,4};
        int[] dit = solution.plusOne(dits);
        for (int i = 0; i < dit.length; i++) {
            //System.out.println(dit[i]);
        }
        int[] nums = {1,2,0,3,0,0,5};
        solution.moveZeroes(nums);
        for (int i = 0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //https://leetcode-cn.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        //求出数字
        int len = digits.length;
        int num = 0;
        int resNum;
        for (int i = 0; i < len; i++) {
            num += digits[i] * (int)Math.pow(10,len-i-1);
        }
        //加1
        resNum = num + 1;
        //求出数组
        String resStr =  String.valueOf(resNum);
        int[] dit = new int[resStr.length()];
        for (int i = 0; i < resStr.length(); i++) {
            Character ch = resStr.charAt(i);
            dit[i] = Integer.parseInt(ch.toString());
        }
        return dit;
    }

    // https://leetcode-cn.com/problems/move-zeroes/
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int current;
        for (int i = 0; i< len; i++) {
            current = nums[i];
            if (current == 0) {
                if (i + 1 < len) {
                    for (int j= i +1; j < len;j++) {
                        if (nums[j] != 0) {
                            nums[i] = nums[j];
                            nums[j] = current;
                            break;
                        }
                    }
                }
            }
        }
    }

}
