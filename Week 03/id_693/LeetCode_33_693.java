package id_693;

import org.junit.Assert;

/**
 * @Desc 33. 搜索旋转排序数组	https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/03
 */
public class LeetCode_33_693 {
    //暴力法：O(n)  ,但是要求是O(log n)哈。。。
    public int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    //暴力：还原(0(long n) -->升序 ->二分：(0(long n)
    public int search3(int[] nums, int target) {
        int point = nums[0];
        int i = 0;
        int j = nums.length - 1;
        int index = 0;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (i + 1 == j) {
                if (nums[i] > nums[j]) {
                    index = j;
                }
                break;
            }
            if (point > nums[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        i = 0;
        j = nums.length - 1;
        if (index == 0) {

        } else if (target < nums[i]) {
            i = index;
        } else {
            j = index - 1;
        }
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    //优化：根据查看题解，发现人家写法，正好可以延伸。
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //看0-mid是否是有序的，如果是，则判断target 大于mid索引值，或小于0索引值，确定范围在右边
            if (nums[0] <= nums[mid] &&
                    (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
                //直接判断是否大于mid索引值且也小于0索引值//确定范围在右边
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        Assert.assertEquals(4, new LeetCode_33_693().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(1, new LeetCode_33_693().search(new int[]{1, 3}, 3));
        Assert.assertEquals(0, new LeetCode_33_693().search(new int[]{1}, 1));
    }
}
