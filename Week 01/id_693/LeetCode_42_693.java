package id_693;

/**
 * @Desc 42. 接雨水  https://leetcode-cn.com/problems/trapping-rain-water/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/20
 */
public class LeetCode_42_693 {
    //暴力破解：直接找出当前左边最大和右边最大值比较谁最小，然后减去自身就是数量。
    public int trap(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            //以当前为起点，找出左边的最大值
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax,height[j]);
            }
            //以当前为起点找出右边的最大值
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax,height[j]);
            }
            //获得左右两边最大值中的最小值 减去自身即可（如果自身是最大值，那么就会是自身-自身）
            max += Math.min(leftMax,rightMax) - height[i];
        }
        return max;
    }

    //优化：使用栈或数组来优化，数据保存最大的

}
