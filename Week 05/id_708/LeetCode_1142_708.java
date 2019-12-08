class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();

        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // 它并没有指定谁包含谁的最长子序列，因此选择其中一个较大的
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // printArrs(dp);
        return dp[row][col];
    }

    private void printArrs(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(Arrays.toString(arrs[i]));
        }
    }
}