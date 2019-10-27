
//leetcode 题号26 有序数组去重问题
//思路：查看了官方题解答案，理解后，默写完成

import java.io.*;
import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] targetBox) {
        //首先判断目标数组是否为空
        if (targetBox.length == 0) return 0;
        //定义左卡尺
        int left = 0;
        //定义右卡尺并循环数组
        for (int right = 1; right < targetBox.length; right++) {
            if (targetBox[right] != targetBox[left]) {
                left++;
                targetBox[left] = targetBox[right];
            }
        }
        // System.out.println("输出：" + Arrays.toString(targetBox)); //真实输出：[1,2,2]
        return left + 1;
    }

    public static void main(String[] args) {
        int[] targetBox = {1,1,2,3,3,5};//有序数组
        Solution solution =  new Solution();
        int result = solution.removeDuplicates(targetBox);
        System.out.println(result); //输出最终结果,去重后数组的长度
    }
}