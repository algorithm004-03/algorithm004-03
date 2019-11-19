/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class LeetCode_33_588 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果左半部分是有序的并且target不在左半部分，则去右半部分查找
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                // 如果[0，mid]之前有旋转点，则去去右半部分查找
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left == right && nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        LeetCode_33_588 solution = new LeetCode_33_588();
        int ret = solution.search(new int[]{8, 9, 0, 1, 4, 7}, 4);
        int ret2 = solution.search(new int[]{8, 9, 0, 1, 4, 7}, 2);
        int ret3 = solution.search(new int[]{5, 6, 7, 8, 9, 0, 1}, 6);
        System.out.println(ret);
        System.out.println(ret2);
        System.out.println(ret3);
    }

}
