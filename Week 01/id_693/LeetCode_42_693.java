package id_693;

/**
 * @Desc 42. 接雨水  https://leetcode-cn.com/problems/trapping-rain-water/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/20
 */
public class LeetCode_42_693 {
    //暴力破解：直接找出当前左边最大和右边最大值比较谁最小，然后减去自身就是数量。    时间O(n^2) 空间O(1)
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

    //优化：使用栈或数组来优化，数据保存最大的,根据暴力破解优化,升维思想   时间O(n) 空间O(n)
    public int trap2(int[] height) {
        int max = 0;
        int left = 0;
        int right = 0;
        int[] leftMax = new int[height.length];//保存左边最大的
        int[] rightMax = new int[height.length];//保存右边最大的
        for (int i = 0; i < height.length; i++) {
            left = Math.max(left,height[i]);
            leftMax[i] = left;
            right = Math.max(right,height[height.length - i - 1]);
            rightMax[height.length - i - 1] = right;
        }
        for (int i = 0; i < height.length; i++) {
            max += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return max;
    }

    //优化：对第二步优化，可以发现左边的和计算结果的循环是重复的，那么就消去左边的 数组
    public int trap3(int[] height) {
        int max = 0;
        int left = 0;
        int right = 0;
        int[] rightMax = new int[height.length];//保存右边最大的
        for (int i = 0; i < height.length; i++) {
            right = Math.max(right,height[height.length - i - 1]);
            rightMax[height.length - i - 1] = right;
        }
        for (int i = 0; i < height.length; i++) {
            left = Math.max(left,height[i]);
            max += Math.min(left,rightMax[i]) - height[i];
        }
        return max;
    }

    //再次优化，使用双指针，还是利用上一次优化进行优化，达到   时间O(n) 空间O(1)
    //根据上一步，如果左边最大值小于右边最大值，那么取左的值，根据之前优化得出，找出左右的最大值，然后找出他们中最小的。
    //          如果左边最大值大于右边最大值，那么取右的值，同上
    //          左右指针谁的值小就进行计算，计算的时候直接看是否是原本的最大值，然后减去自身即可。(不同的时候，建议从上面几步解法一步步的来)
    public int trap4(int[] height) {
        int max = 0;

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax,height[left]);
                max += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax,height[right]);
                max += rightMax - height[right];
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_42_693().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new LeetCode_42_693().trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new LeetCode_42_693().trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new LeetCode_42_693().trap4(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
