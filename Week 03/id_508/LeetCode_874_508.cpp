class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int x = 0,y = 0;
        int res = 0;
        set<pair<int,int>> obs;
        for(auto i:obstacles) {
            obs.insert(pair(i[0],i[1]));
        }
        int dir = 0;
        for(auto com:commands) {

            if(com>0) {
                while(com--) {
                    x+=dx[dir];
                    y+=dy[dir];
                    if(obs.find(pair(x,y))!=obs.end()) {
                        x-=dx[dir];
                        y-=dy[dir];
                        break;
                    }
                res = max(res,x*x+y*y);
                }
            } else {
                dir = (dir + 2*com +7)%4;
            }
        }
        return res;
    }
};
