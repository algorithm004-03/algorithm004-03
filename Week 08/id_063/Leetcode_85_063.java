/*

从上到下求以每一层为底最大矩形面积，最后答案取最大的一个
每一层迭代的时候可以维护一个高度数组，高度数组h[j]表示当前行上
第j列累计的1的个数, 每一层的h数组可以用dp方式进行递推
每一层的计算就可以抽象成一维问题：
h数组中找每个数左边第一个比它大和右边第一个比它小的数据的位置，用单调栈解决

时间复杂度 n^2

*/

import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] h = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            }

            // 单调栈找边界
            Stack<Integer> s = new Stack<>();
            int lBound = 0, idx = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (s.isEmpty()) {
                    s.add(j);
                } else {
                    while (!s.isEmpty() && h[s.peek()] > h[j]) {
                        idx = s.pop();
                        lBound = s.isEmpty() ? -1 : s.peek();
                        maxArea = Math.max(maxArea, (j - lBound - 1) * h[idx]);
                    }
                    s.add(j);
                }
            }

            while (!s.isEmpty()) {
                idx = s.pop();
                lBound = s.isEmpty() ? -1 : s.peek();
                maxArea = Math.max(maxArea, (matrix[0].length - lBound - 1) * h[idx]);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalRectangle(new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}