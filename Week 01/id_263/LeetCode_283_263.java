package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 16:56
 */
public class LeetCode_283_263 {

    public void moveZeroes(int[] nums) {

        int indexOfNoneZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[indexOfNoneZero] = nums[i];
                if (i != indexOfNoneZero) {
                    nums[i] = 0;
                }
                indexOfNoneZero++;
            }
        }
    }
}
