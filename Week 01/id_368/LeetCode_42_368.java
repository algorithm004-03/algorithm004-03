/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/25
 */
public class LeetCode_42_368 {

    /*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    https://leetcode-cn.com/problems/trapping-rain-water/*/

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        // 按照列来求面积
        // 当前列的面积：当前列高度、左侧最高的高度、右侧最高高度
        // 只有左右最高高度中的较低的高度 > 当前列高度：才可以积水，面积为高度差
        int sum = 0;
        if (height == null || height.length == 0) {
            return sum;
        }
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }

            int max_right = 0;
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] > max_right) {
                    max_right = height[k];
                }
            }

            int min = Math.min(max_left, max_right);
            if (height[i] < min) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    public static int trap01(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (height[i] < min) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}
