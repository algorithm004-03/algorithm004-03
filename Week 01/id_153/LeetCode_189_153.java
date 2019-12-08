
/**
 * LeetCode_189_153
 * 
 * @desc LeetCode 189 题 https://leetcode-cn.com/problems/rotate-array/
 */

public class LeetCode_189_153 {

  /**
   * 暴力法求解，两层嵌套循环 每次只先移动一个元素
   * 
   * @param nums
   * @param k
   */
  public void rotate1(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      int last = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        int temp = nums[j];
        nums[j] = last;
        last = temp;
      }
    }
  }

  /**
   * 可以先算出每个元素移动 k 次之后，最终的位置，存到一个新数组 然后循环将元素一一复制过去即可。 最开始就想到的是这个办法，在推到计算公式时，把数组
   * nums 的长度看错了， 导致推导出来的公式是错的。
   * 
   * @param nums
   * @param k
   */
  public void rotate2(int[] nums, int k) {
    int[] arr = new int[nums.length];
    for (int i = 0; i < arr.length; i++) {
      int end = (i + k) % nums.length;
      arr[end] = nums[i];
    }

    for (int i = 0; i < arr.length; i++) {
      nums[i] = arr[i];
    }
  }
}