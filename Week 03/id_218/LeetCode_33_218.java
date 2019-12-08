package leetcode.week3;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 *
 * @author eason.feng at 2019/11/3/0003 19:17
 **/
public class LeetCode_33_218 {

    public static void main(String[] args) {
        LeetCode_33_218 leetCode_33_218 = new LeetCode_33_218();
        int arr[] = {4,5,6,7,0,1,2};
        int res = leetCode_33_218.search(arr, 5);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            else {
                return -1;
            }
        }
        return matchTarget(0, nums.length - 1, target, nums);
    }

    private int matchTarget(int low, int high, int target, int[] nums) {
        if(nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }
        if (low == high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] > target){
            if (nums[low] > target) {
                if (nums[low] < nums[mid]) {
                    return this.matchTarget(mid + 1, high, target, nums);
                }
                else {
                    if (mid - 1 < 0 || mid - 1 < low) {
                        return -1;
                    }
                    return this.matchTarget(low, mid - 1, target, nums);
                }
            }
            else {
                if (mid - 1 < 0 || mid - 1 < low) {
                    return -1;
                }
                return this.matchTarget(low, mid - 1, target, nums);
            }
        }
        else {
            if (nums[mid] > nums[high]) {
                return this.matchTarget(mid + 1, high, target, nums);
            }
            else {
                if (nums[high] > target) {
                    if (mid + 1 >= nums.length || mid + 1 > high) {
                        return -1;
                    }
                    return this.matchTarget(mid + 1, high, target, nums);
                }
                else {
                    if (mid - 1 < 0 || mid - 1 < low) {
                        return -1;
                    }
                    return this.matchTarget(low, mid - 1, target, nums);
                }
            }
        }
    }

}
