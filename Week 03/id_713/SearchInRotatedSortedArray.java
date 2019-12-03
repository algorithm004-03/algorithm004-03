package id_713;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray {


    /*
    思路:
    时间复杂度 O(logN) 则意味着: 要使用二分查找了

    1 2 3 4 5 6 7 可以分成2种情况
        2 3 4 5 6 7 1
        6 7 1 2 3 4 5

        第一类 2 3 4 5 6 7 1 也就 nums[left] <= nums[mid] 2 <= 5
            这种情况下, 前半部分有序
            如果 nums[left] <= target < nums[mid], 则在前半部分查找, 否则后半部分

        第二类 6 7 1 2 3 4 5 也就是 nums[left] > nums[mid] 6 > 2
            这种情况下, 后半部分有序
            如果 nums[mid] < target <= nums[right], 则在后半部分查找, 否则前半部分

     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = (right - left) / 2 + left; // 相当于 (right + left) / 2

            if (nums[mid] == target) return mid;

            // 前半部分有序, 包含mid
            if (nums[left] <= nums[mid]) {
                // target在前半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 后半部分有序
                // target 后半部分
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }


        }

        return -1;
    }

}
