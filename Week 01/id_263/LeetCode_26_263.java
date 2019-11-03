package io.beansoft.pencil.leetcode;



/**
 *
 *
 * @author beanlam
 * @date 2019-10-20 13:03
 * @version 1.0
 */
public class LeetCode_26_263 {

    public int removeDuplicates(int[] nums) {
        // 边界
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int previousUniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i-1]) {
                continue;
            } else {
                nums[++previousUniqueIndex] = nums[i];
            }
        }

        return previousUniqueIndex + 1;
    }

}
