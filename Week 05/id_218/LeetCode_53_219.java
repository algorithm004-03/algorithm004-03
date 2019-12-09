package leetcode.week5;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author eason.feng at 2019/11/17/0017 17:21
 **/
public class LeetCode_53_219 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(0, nums[i - 1]) + nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
