/**
 * 搜索旋转排序数组
 *
 * 二分查找
 * 时间复杂度O(logn), 空间复杂度O(1)
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 90.56% * 的用户
 * 内存消耗 : * 36.2 MB * , 在所有 java 提交中击败了 * 85.46% * 的用户
 */
class Leetcode33SolutionOne {
  public int search(int[] nums, int target) {
    // 边界条件
    if (nums == null || nums.length == 0) {
      return -1;
    }

    // 只有一个元素
    if (nums.length == 1) {
      if (nums[0] == target) {
        return 0;
      } else {
        return -1;
      }
    }

    // 2个元素及以上
    int pivot = _findPivot(nums);
    if (pivot == 0) {
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    int result = binarySearch(nums, 0, pivot-1, target);
    if (result != -1) {
      return result;
    } else {
      result = binarySearch(nums, pivot, nums.length - 1, target);
    }

    return result;
  }

  // normal binary search
  public int binarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  private int _findPivot(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
        return mid + 1;
      } else if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return 0;
  }
}
