/*
 * @lc app=leetcode id=64 lang=cpp
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int column = grid[0].size();
        vector<vector<int>> dp(row , vector<int>(column));
        for(int i = grid.size() - 1;i>=0;i--)
        {
            for(int j = grid[0].size()-1;j>=0;j--)
            {
                if(i==grid.size() -1 && j !=grid[0].size()-1)
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                else if(j == grid[0].size()-1 && i != grid.size()-1)
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                else if(j != grid[0].size() - 1 && i != grid.size() - 1)
                    dp[i][j] = grid[i][j] + min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j]; 
            }
        }
        return dp[0][0];
    }
};
// @lc code=end

