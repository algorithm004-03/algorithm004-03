/*
 * 874. 模拟行走机器人
 */

class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int dir = 0;
        int x = 0, y = 0;

        set<pair<int,int>> obstacleSet;
        for(vector<int> obstacle : obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));

        int res = 0;
        for(int cmd : commands) {
            if(cmd == -1)
                dir = (dir+1)%4;
            else if(cmd == -2)
                dir = (dir+3)%4;
            else {
                for(int i=0; i<cmd; ++i) {
                    x += dx[dir];
                    y += dy[dir];
                    if(obstacleSet.count(make_pair(x, y)) == 1) {
                        x -= dx[dir];
                        y -= dy[dir];
                        break;                     
                    }
                }
                res = max(res, x*x+y*y);
            }
        }

        return res;
    }
};