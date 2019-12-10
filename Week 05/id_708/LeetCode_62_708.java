// 动态递推
class Solution {
    // 自底向上，计算 paths[i][j] 的可能走法
    // paths[i][j] = paths[i-1][j] + paths[i][j-1] 即下面和右边走法之和
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) dp[i][n-1] = 1;
        for (int i = 0; i < n; i++) dp[m-1][i] = 1;
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

// 分治法
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return helper(m, n, 0, 0);
//     }

//     private int helper(int m, int n, int curRow, int curCol) {
//         if (!isValidSquare(m, n, curRow, curCol)) return 0;
//         if (isAtEnd(m, n, curRow, curCol)) return 1;
//         // 只能往下走或往右走
//         return helper(m, n, curRow+1, curCol) + helper(m, n, curRow, curCol+1);
//     }

//     private boolean isValidSquare(int m, int n, int curRow, int curCol) {
//         return curRow >= 0 && curRow < m && curCol >= 0 && curCol < n;
//     }

//     private boolean isAtEnd(int m, int n, int curRow, int curCol) {
//         return curRow == m-1 && curCol == n-1;
//     }
// }