package Week03;

/**
 * @Date 2019/11/3.
 * @see <a href="153">https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/</a>
 * 寻找旋转排序数组中的最小值
 */
public class LeetCode_153_558 {

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
