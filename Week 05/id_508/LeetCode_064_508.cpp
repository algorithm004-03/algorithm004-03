public:
    int minPathSum(vector<vector<int>>& grid) {
        //problem(i,j) = min(subproblem(i+1,j),subproblem(i,j+1))
        //dp[]
        //backward
        //dp[i] = min(dp[i]，dp[i+1]);
        int ROW = grid.size();
        int COL = ROW>0?grid[0].size():0;
        bool start = false;
        for(int i = ROW-1;i>=0;i--) {
            for(int j = COL -1;j>=0;j--) {
                if(!start) {start = true;continue;};
                grid[i][j] = min((i<(ROW-1)?grid[i+1][j]:INT_MAX),
                (j<(COL-1)?grid[i][j+1]:INT_MAX))+grid[i][j];
            }
        }
        return grid[0][0];
    }

};
