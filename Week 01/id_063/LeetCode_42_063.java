/*
动态规划算法, 暴力算法迭代每一根柱子都需要左右两个方向扫描到底查找左边最高的柱子和右边最高柱子
进行了重复计算，可以用动态规划的方式先把每个柱子左边最高的柱子高度和每个柱子右边最高的柱子高度算出来

设dpLeftMax[i] 表示柱子i左边最高的柱子高度, 则有如下递推关系
    若 height[i-1] > dpLeftMax[i-1], 则dpLeftMax[i] = height[i-1]
    否则 dpLeftMax[i] = dpLeftMax[i-1]

设dpRightMax[i] 表示柱子i右边最高的柱子的高度，有如下递推关系
    若 height[i+1] > dpRightMax[i+1], 则dpRightMax[i] = height[i+1]
    否则 dpRightMax[i] = dpRightMax[i+1]

    两次线性扫描可以更新完两个Dp数组，第三次从左到右扫描所有柱子计算每一个柱子的出水量，然后累加即可
 */

class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int totalLen = height.length;
        int[] dpLeftMax = new int[totalLen];
        int[] dpRightMax = new int[totalLen];

        // dp 算法递推
        dpLeftMax[0] = 0;
        for (int i = 1; i < totalLen; i++) {
            dpLeftMax[i] = Math.max(height[i-1], dpLeftMax[i-1]);
        }

        // dp 算法递推
        dpRightMax[totalLen-1] = 0;
        for (int i = totalLen-2; i >= 0; i--) {
            dpRightMax[i] = Math.max(height[i+1], dpRightMax[i+1]);
        }

        // 累加水量
        int area = 0;
        int waterHeight;
        for (int i = 1; i < totalLen-1; i++) {
            waterHeight = Math.min(dpLeftMax[i], dpRightMax[i]);
            if (waterHeight > height[i]) {
                area += (waterHeight - height[i]);
            }
        }

        return area;
    }
}