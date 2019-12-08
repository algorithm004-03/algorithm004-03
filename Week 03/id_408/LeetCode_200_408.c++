class Solution {
public:
    bool inGrid(vector<vector<char>>& grid, pair <int,int> a) 
    {
        if(a.first >= 0 && a.first < grid.size() && a.second >= 0 && a.second < grid[0].size())
            return true;
        else 
            return false;
    }

    int numIslands(vector<vector<char>>& grid) {
        int ans = 0;
        queue <pair<int,int>> po;
        if(grid.empty()) return 0; 
        int m = grid.size();
        int n = grid[0].size();
        for(int y = 0; y < m; ++y) 
        {
            for(int x = 0; x <n; ++x)
            {
                if(grid[y][x] == '1') 
                {
                    po.push({y,x});
                    
                    ++ans; 
                    while(!po.empty()) 
                    {
                        
                        pair <int,int> temp = po.front();
                        po.pop();
                        if(grid[temp.first][temp.second] == '0') 
                            continue;
                        grid[temp.first][temp.second] = '0';
                        pair <int,int> up = {temp.first + 1, temp.second}; 
                        pair <int,int> down = {temp.first - 1, temp.second};
                        pair <int,int> left = {temp.first, temp.second - 1};
                        pair <int,int> right = {temp.first, temp.second + 1};
                        if(inGrid(grid,up) && grid[temp.first + 1][temp.second] == '1') 
                            po.push(up);
                        if(inGrid(grid,down) && grid[temp.first - 1][temp.second] == '1')
                            po.push(down);
                        if(inGrid(grid,left) && grid[temp.first][temp.second - 1] == '1')
                            po.push(left);
                        if(inGrid(grid,right) && grid[temp.first][temp.second + 1] == '1')
                            po.push(right);
                    }
                }
            }
        }
        return ans;
    }
};
