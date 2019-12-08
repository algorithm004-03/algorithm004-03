/*

找以第i层为底的最大正方形，最后答案就是i从0到n-1中所有最大正方形中最大的一个

每一层计算的时候构建dp[j]数组，dp[j]表示当前作为底那一层中，第j列从位置上从第0行到当前行的累加和
当前层的dp数组可以用上一层的dp数组的数值加上当前层的矩阵数值得出
，这样计算每一层的最大正方形的时候就可以转换成一个单调栈问题
整个时间复杂度O(N*N)

 */


import java.util.Stack;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        int[] dp = new int[colLen];
        int maxLen = 0;

        // i = 0 时候进行初始化
        for (int j = 0; j < colLen; j++) {
            if (matrix[0][j] == '1') {
                maxLen = 1; dp[j] = 1;
            }
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                dp[j] = (matrix[i][j] == '1') ? dp[j] + 1 : 0;
            }

            Stack<Integer> stack = new Stack<>();

            int val, left, right, len;
            for (int j = 0; j < colLen; j++) {
                if (stack.size() ==0) {
                    stack.add(j);
                    continue;
                }


                while ((stack.size() > 0) && (dp[j] < dp[stack.peek()])) {
                    val = dp[stack.pop()];
                    left = stack.isEmpty() ? -1 : stack.peek();
                    len = j - left - 1;

                    maxLen = Math.max(Math.min(val, len), maxLen);
                }

                stack.add(j);
            }

            // 清空栈
            while (!stack.isEmpty()) {
                val = dp[stack.pop()];
                left = stack.isEmpty() ? -1 : stack.peek();
                len = colLen - left - 1;
                maxLen = Math.max(Math.min(val, len), maxLen);
            }
        }

        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}