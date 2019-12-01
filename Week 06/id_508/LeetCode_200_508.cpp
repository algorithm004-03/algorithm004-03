class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int k = 0;
        int res = 0;

        deque<pair<int,int>> que;
        for(int i = 0; i< grid.size() ; i++ ) {
            for (int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == '1') {
                    k++;
                    que.push_back(pair(i,j));
                    while(!que.empty()) {
                        int x = que.front().first;
                        int y = que.front().second;
                        que.pop_front();
                        if(grid[x][y] == '0' ||grid[x][y] =='v') continue;

                        grid[x][y] = 'v';
                        if (x&&grid[x-1][y]=='1') {que.push_back(pair(x-1,y));
                        }
                        if (x<(grid.size()-1)&&grid[x+1][y]=='1') {que.push_back(pair(x+1,y));
                        }
                        if (y&&grid[x][y-1]=='1') {que.push_back(pair(x,y-1));
                        }
                        if (y<(grid[0].size()-1)&&grid[x][y+1]=='1') { que.push_back(pair(x,y+1));
                        }
                    }
                }

            }
        }
        return k;
    }
};
