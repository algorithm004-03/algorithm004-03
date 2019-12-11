import java.util.Arrays;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // //20191207
        // //复杂度O(m*n)
        // int [][]dp = new int[m][n];
        // for(int i=0;i<n;i++)
        //     dp[0][i]=1;
        // for(int i=0;i<m;i++)
        //     dp[i][0]=1;
        // for(int i=1;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         dp[i][j] = dp[i-1][j]+dp[i][j-1];
        //     }
        // }
        // return dp[m-1][n-1];


        // //20191207
        // //复杂度O(2n)
        // int []pre = new int[n];
        // int []cur = new int[n];
        // Arrays.fill(pre,1);
        // Arrays.fill(cur,1);
        // for(int i=1;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         cur[j] = cur[j-1]+pre[j];
        //     }
        //     pre = cur.clone();
        // }
        // return pre[n-1];


        //20191207
        //复杂度O(n);
        int []cur = new int[n];
        Arrays.fill(cur, 1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }
}
// @lc code=end

