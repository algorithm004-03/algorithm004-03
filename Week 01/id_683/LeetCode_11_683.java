class Solution {

    /**
     * 从两边向中间收敛
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] > height[j] ? height[j--] : height[i++];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int x = 0; x < height.length - 1; ++x) {
            for (int y = x + 1; y < height.length; ++y) {
                max = Math.max(max, (y - x) * Math.min(height[x], height[y]));
            }     
        }
        return max;
    }
}