/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * @author gning (id=698)
 */

 public class LeetCode_45_698 {

    public int jump(int[] nums) {
        if(nums == null || nums.length ==0) {
            return 0;
        }

        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i=0; i<nums.length-1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);

            if(i==end) {
                end = maxPosition;
                steps ++;
            }

        }

        return steps;

    }
 }