/**
 * 接雨水
 * @author Lukas
 * @since 2019/10/19 22:08
 **/
public class LeetCode_42_138 {

    /**
     * 暴力法求解：按行求解
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        int max = getMaxHeight(height);//获取最高度
        for (int row = 1; row <= max; row++) {//一行行遍历，从1开始
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < row) {
                    temp_sum++;
                }
                if (height[j] >= row) {
                    sum += temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMaxHeight(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }


    public int trap2(int[] height) {
        int sum = 0;
        final int length = height.length;
        int[] max_left = new int[length];//第i列左侧最高的值
        int[] max_right = new int[length];//第i列右侧最高度值
        for (int i = 1; i < length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i-1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }

        for (int i = 1; i < length-1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}
