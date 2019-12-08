package week2;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 169. Majority Element
 * @author: 王瑞全
 * @create: 2019-10-2811:52
 **/


public class leetcode169_2_468 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
