package com.company.leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_42 {

    private Stack<Integer> stack = new Stack();

    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        int area = 0;
        int current = 0;
        while (current < height.length) {

            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }

                int distance = current - stack.peek() - 1;
                int h = Math.min(height[current],height[stack.peek()]) - height[top];
                area += distance * h;
            }

            stack.push(current++);
        }

        return area;
    }

    public static void main(String[] args) {
        Solution_42 s = new Solution_42();
        int area = s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        int area = s.trap(new int[]{4,2,3});
        System.out.println(area);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
