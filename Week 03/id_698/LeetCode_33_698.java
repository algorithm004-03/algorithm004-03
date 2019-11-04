/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @author gning (id=698)
 */

public class LeetCode_33_698 {

    public int search(int nums[], int target) {
        int left = 0;
        int right = nums.length -1;

        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if ( target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            }else {
                right = mid;
            }

        }

        return left == right && nums[left] == target ? left : -1;
    }


}