class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        deque<pair<int,int>> que;
        que.push_back(pair(click[0],click[1]));
        while(!que.empty()) {
            int x = que.front().first;
            int y = que.front().second;

            que.pop_front();

            if(board[x][y]=='M') {
                board[x][y] =  'X';
            } else if(board[x][y] == 'E' ) {
                int n = 0;
                for(int i = max(0,x-1);i<min(x+2,static_cast<int>(board.size()));i++) {
                    for (int j = max(0,y-1);j<min(y+2,static_cast<int>(board[0].size()));j++) {
                        if(board[i][j] == 'M') n++;
                    }
                }
                if(n) board[x][y] = '0'+n;
                else {
                    board [x][y] = 'B';
                    for(int i = max(0,x-1);i<min(x+2,static_cast<int>(board.size()));i++) {
                        for (int j = max(0,y-1);j<min(y+2,static_cast<int>(board[0].size()));j++) {
                            que.push_back(pair(i,j));
                        }
                    }
                }
            }
        }
        return board;
    }
};
