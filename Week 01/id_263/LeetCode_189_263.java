package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 13:29
 */
public class LeetCode_189_263 {

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }

        k = k % nums.length;
        if (k == 0) {
            return;
        }


        int beginIndex = 0;
        int currentIndex = 0;

        int prevValue = nums[currentIndex];

        int count = 1; // 限制总次数
        while (count <= nums.length) {
            int nextIndex = (currentIndex + k) % nums.length;

            int temp = nums[nextIndex];
            nums[nextIndex] = prevValue;
            prevValue = temp;
            currentIndex = nextIndex;

            if (currentIndex == beginIndex) {//遇到循环，初始位置向前步进，同时更新缓存值
                currentIndex++;
                beginIndex++;
                prevValue = nums[currentIndex];
            }

            count++;
        }

    }
}