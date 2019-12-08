/*
 * 64. 最小路径和
 */

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.empty())
            return 0;
        
        int rows = grid.size();
        int cols = grid[0].size();
        
        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) {
                if(i==0 && j==0)
                    grid[i][j] = grid[i][j];
                else if(i==0)
                    grid[i][j] += grid[i][j-1];
                else if(j==0)
                    grid[i][j] += grid[i-1][j];
                else
                    grid[i][j] += min(grid[i][j-1], grid[i-1][j]);
            }
        }

        return grid[rows-1][cols-1];
    }
};