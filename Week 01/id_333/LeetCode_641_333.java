public class LeetCode_641_333 {

    public static int trap(int[] height) {
        int max = 0;
        int maxIndex = 0;
        //寻找最高的柱子
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int maxLeft = 0;
        int result = 0;
        //计算最高柱子左侧的雨水收集
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            } else {
                result += maxLeft - height[i];
            }
        }
        int maxRight = 0;
        //计算最高柱子右侧的雨水收集
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > maxRight) {
                maxRight = height[i];
            } else {
                result += maxRight - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] con = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print("water capacity:" + trap(con));
    }
}
