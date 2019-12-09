/**
 * 接雨水
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class LeetCode_42_588 {

    /**
     * 暴力解法
     */
    public int trappingRain(int[] a) {

        int ret = 0;
        for (int i = 0; i < a.length - 1; i ++) {
            int maxLeft = 0;
            int maxRight = 0;
            // 找到左边最大高度
            for (int j = i; j >= 0; j --) {
                maxLeft = Math.max(maxLeft, a[j]);
            }
            // 找到右边最大高度
            for (int j = i; j < a.length; j ++) {
                maxRight = Math.max(maxRight, a[j]);
            }
            ret = ret + Math.min(maxLeft, maxRight) - a[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        LeetCode_42_588 solution = new LeetCode_42_588();
        System.out.println(solution.trappingRain(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
