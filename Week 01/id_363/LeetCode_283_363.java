package com.test.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * done 20191015
 * done 20191016
 * todo 20191017 看leetcode most-votes 前面三个
 * todo 20191022 看leetcode most-votes 前面三个
 * @return
 */
public class SolutionMoveZero283 {



    @Test
    public void test1() {
        moveZeroes_20191016_1(new int[]{0,1,0,3,12});
        moveZeroes_20191016_1(new int[]{0,0,1});
        moveZeroes_20191016_1(new int[]{1});
        System.out.println("-----------------");
        moveZeroes_20191016_2(new int[]{0,1,0,3,12});
        moveZeroes_20191016_2(new int[]{0,0,1});
        moveZeroes_20191016_2(new int[]{1});
        System.out.println("---------------------");
        moveZeroes_20191016_3(new int[]{0,1,0,3,12});
        moveZeroes_20191016_3(new int[]{0,0,1});
        moveZeroes_20191016_3(new int[]{1});
    }


    /**
     * 暴力：遍历数组时遇到0，则把零和下一下不是0的数字进行交换
     * 循环：先把不是0的数挪到数组的最前面，后面补 0
     * 循环：每个数前面有多少0就往前挪几位
     * @param nums
     */
    public void moveZeroes_20191016_1(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < len ; i ++) {
            if (nums[i] == 0) {
                int nowIndex = i;
                while (nowIndex < len && nums[nowIndex] == 0) {
                    nowIndex += 1;
                }
                if (nowIndex == len) {
                    break;
                }
                nums[i] = nums[nowIndex];
                nums[nowIndex] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes_20191016_2(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int lastNonZeorIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeorIndex ++] = nums[i];
            }
        }
        for (int i = lastNonZeorIndex; i < nums.length; i ++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 最优 best
     * @param nums
     */
    public void moveZeroes_20191016_3(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroCount > 0) {
                    nums[i - zeroCount] = nums[i];
                    nums[i] = 0;
                }
            } else {
                zeroCount += 1;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
