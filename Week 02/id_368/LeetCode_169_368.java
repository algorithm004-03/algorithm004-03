import java.util.HashMap;
import java.util.Map;

public class LeetCode_169_368 {

    /*给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在众数。
    https://leetcode-cn.com/problems/majority-element/*/

    public static void main(String[] args) {

    }

    public int majorityElementIterator(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int countMajor = nums.length / 2;
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 0);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > countMajor) {
                return entry.getValue();
            }
        }
        return -1;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majority(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi-lo)/2 + lo;
        int left = majority(nums, lo, mid);
        int right = majority(nums, mid+1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length-1);
    }
}
