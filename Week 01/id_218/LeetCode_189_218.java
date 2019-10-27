package leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-array/submissions/
 *
 * @author eason.feng at 2019/10/20/0020 16:39
 **/
public class LeetCode_189_218 {

    /**
     * by reversing array
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length <= 1 || nums.length == k) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * Brute force way
     * @param nums
     * @param k
     */
    public void rotateBruteForce(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length <= 1 || nums.length == k) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        while (k > 0) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
            k--;
        }
    }

}
