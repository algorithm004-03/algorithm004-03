package leetcode.week3;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 *
 * @author eason.feng at 2019/11/3/0003 18:51
 **/
public class LeetCode_153_218 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return getMin(0, nums.length - 1, nums);
    }

    private int getMin(int low, int high, int[] nums) {
        int mid = (low + high) / 2;
        if (nums[mid] < nums[high]) {
            high = mid;
            return getMin(low, high, nums);
        } else {
            if (low == high) {
                return nums[low];
            }
            low = mid + 1;
            return getMin(low, high, nums);
        }
    }

}
