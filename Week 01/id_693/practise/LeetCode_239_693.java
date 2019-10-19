package id_693.practise;

import java.util.Arrays;

/**
 * @Desc 239. 滑动窗口最大值    https://leetcode-cn.com/problems/sliding-window-maximum/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/19
 */
public class LeetCode_239_693 {

    //自己暴力破解  O(nk)
    //你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
    // 所以 k 是 大于等于数组，且k 在数组不为null的时候会是大于等于1
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] resule = new int[nums.length - k + 1];
        for (int i = 0; i < resule.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            resule[i] = nums[maxIndex];
        }
        return resule;
    }

    //对第一个进行代码优化
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] resule = new int[nums.length - k + 1];
        for (int i = 0; i < resule.length; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            resule[i] = max;
        }
        return resule;
    }

    //使用双端队列试试 达到 O(n log(k))


    //网上效率最高的 0(n)  采用的动态规划
    //如果每移动一次就去遍历窗口的值，这样时间复杂度是O（n*k）
    //可以改进成用一个变量存储窗口最大值，每进来一个新值就进行跟最大值比较即可，当最大值出窗口了再遍历当前窗口的最大值。
    public int[] maxSlidingWindow4(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length + 1 - k];
        int index = -1;
        int maximum = nums[0];

        for (int i = 0; i < result.length; i++) {
            if (index < i) {
                maximum = nums[i];
                index = i;
                for (int j = i + 1; j < k + i; j++) {
                    if (!(maximum > nums[j])) {
                        maximum = nums[j];
                        index = j;
                    }
                }
            } else {
                if (!(maximum > nums[i + k - 1])) {
                    maximum = nums[i + k - 1];
                    index = i + k - 1;
                }
            }
            result[i] = maximum;
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1, 3}, 3)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1, 3}, 1)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{}, 0)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{}, 2)));
        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1}, 2)));
    }
}
