package com.jane.part42;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        int current = 0;

        Stack<Integer> stack = new Stack<>();
        while(current < height.length){
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                maxArea += distance * boundedHeight;
            }
            stack.push(current++);
        }

        return maxArea;
    }

    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6, trap(height));
    }
}
