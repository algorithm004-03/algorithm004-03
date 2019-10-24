package id_693.practise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
            return new int[0];
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
            return new int[0];
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

    //使用双端队列试试 达到 O(n log(k))   参考国际站，利用了双端队列的两头可取值的特点
    //原理：
    //1、for循环中的 第一个while循环 是把超出边界的下标都pop
    //2、for循环中的 第二个while循环 是把所有前面小于或者等于自己的pop (从开始就这样那么前面的都是从大到小排序的，而且每次都循环pop了)
    //3、i >= K - 1 说明下标已经在 0 - （k-1） 的范围，已经有k个数了。可以开始计算，然后拿出头即可
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            //循环删除超出左边界的，并移除
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pop();
            }
            //循环检查 最后的元素小于当前，则删除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //添加
            deque.offer(i);
            //当数组元素检索到可 k - 1 则可以开始返回数组元素赋值了。
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        return result;
    }

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
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[0], 0)));
//        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[0], 2)));
        System.out.println(Arrays.toString(new LeetCode_239_693().maxSlidingWindow(new int[]{1}, 2)));
    }
}
