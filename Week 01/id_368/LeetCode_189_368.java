import java.util.Arrays;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/22
 */
public class LeetCode_189_368 {

    /*给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
    https://leetcode-cn.com/problems/rotate-array/*/

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate02(nums, k);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }

    public static void rotate01(int[] nums, int k) {
        //暴力法：向右移动k个位置相当于是将k个最末尾的元素移动到头部
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if (k == nums.length) {
            return;
        }
        int temp;
        while (k > 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            k--;
        }
    }

    public static void rotate02(int[] nums, int k) {
        // 反转
        k = k % nums.length;
        if (k == nums.length) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse (int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
