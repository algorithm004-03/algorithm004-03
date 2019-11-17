package com.homework.week3;

//参考官方题解
public class LeeCode_45_103 {

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if ( i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
