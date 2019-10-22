package id_693.practise;

/**
 * @Desc 11. 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/17
 */
public class LeetCode_11_693 {
    //暴力破解，直接计算所有可能，返回最大值 O(n^2)
    public int maxArea(int[] height) {
        int max = 0;
        int tempArea;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                tempArea = (j - i) * Math.min(height[i],height[j]);
                max = Math.max(max,tempArea);
            }
        }
        return max;
    }

    //双指针优化，0(n)
    public int marArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            max = Math.max(max,minHeight * (right - left + 1));
        }
        return max;
    }
}
