package practice;

import java.util.LinkedList;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/23
 */
public class LeetCode_239_368 {

    /* 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
    你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    返回滑动窗口中的最大值。
    链接：https://leetcode-cn.com/problems/sliding-window-maximum */

    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 暴力法
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    public static int[] maxSlidingWindow01(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 排序
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            // 校验队首是否在窗口内
            if (deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            // 保存最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
