package com.leetcode.kelvin;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kelvin
 * @date 2019/10/20 11:17 PM
 */
public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        int current = 0;
        while (current < height.length) {

            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.removeFirst();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.addFirst(current);
            current++;
        }
        return sum;

    }
}
