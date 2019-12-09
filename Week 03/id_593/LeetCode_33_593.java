
/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 四步刷题法：
 * 1. clarification
 * 数组是一个 升序 有序数组，在某个一个结点进行了旋转得到的，也就是整体部份为有序。 时间复杂度，log N ，提醒我们可以考虑一下二分查找。
 * 2. possible solution -> optimal(space / time)
 * 思路：二分查找；先排序的方案，也能做到log N
 * 3. code
 * 4. test case
 *
 * @author jaryoung
 * @version 1.0 参考了别人的写法，并且自己能理解的写法
 */
public class LeetCode_33_593 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return length > 0 && nums[left] == target ? left : -1;
    }
}