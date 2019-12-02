package lesson3;

public class LeetCode_42_633 {
    // 1. 暴力法
    public int trap(int[] height) {
        int s = 0; // 面积
        // 枚举i
        for (int i = 0; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            // 计算左边最高高度
            for (int j = i; j >= 0; --j) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 计算右边最高高度
            for (int j = i; j < height.length; ++j) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 计算围成的凹槽中 遍历到i对应这个条的面积
            // 注意,一次计算，不是 maxRight 与 maxLeft 及 height[i]围成的的整个面积
            // 仅仅是凹槽中下标为i这个竖条在凹槽中的面积
            s += Math.min(maxLeft, maxRight) - height[i];
        }
        return s;
    }
}
