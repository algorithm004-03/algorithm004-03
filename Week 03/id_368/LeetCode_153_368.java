public class LeetCode_153_368 {

    /*假设按照升序排序的数组在预先未知的某个点上进行了旋转。
            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    请找出其中最小的元素。
    你可以假设数组中不存在重复元素。
    链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array*/

    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] >= nums[left]) {
            return nums[left];
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
