/*
 * 200. 岛屿数量
 */

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<char>> map = grid;
        int islands = 0;

        for(int i=0; i<map.size(); ++i) {
            for(int j=0; j<map[0].size(); ++j) {
                if(map[i][j] == '1') {
                    islands++;
                    sinkIslands(map, i, j);
                }
            }
        }

        return islands;
    }

    void sinkIslands(vector<vector<char>>& map, int x, int y) {
        if(x<0 || x==map.size() || y<0 || y==map[0].size() || map[x][y] == '0')
            return;
        
        map[x][y] = '0';

        sinkIslands(map, x-1, y);
        sinkIslands(map, x+1, y);
        sinkIslands(map, x, y-1);
        sinkIslands(map, x, y+1);
    }
};