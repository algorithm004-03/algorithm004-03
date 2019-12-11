/*
 * 529. 扫雷游戏
 */

class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if(board.empty() || click.empty())
            return board;
        
        if(board[click[0]][click[1]] == 'M')
            board[click[0]][click[1]] = 'X';
        else
            reveal(board, click[0], click[1]);
        
        return board;
    }

    bool isLegal(vector<vector<char>>& board, int x, int y) {
        return (x>=0 && x<board.size() && y>=0 && y<board[0].size());
    }

    void reveal(vector<vector<char>>& board, int x, int y) {
        if(!isLegal(board, x, y) || board[x][y]!='E')
            return;
        
        int mines = 0;
        if(isLegal(board, x-1, y-1) && board[x-1][y-1]=='M') mines++;
        if(isLegal(board, x-1,  y ) && board[x-1][ y ]=='M') mines++;
        if(isLegal(board, x-1, y+1) && board[x-1][y+1]=='M') mines++;
        if(isLegal(board,  x , y-1) && board[ x ][y-1]=='M') mines++;
        if(isLegal(board,  x , y+1) && board[ x ][y+1]=='M') mines++;
        if(isLegal(board, x+1, y-1) && board[x+1][y-1]=='M') mines++;
        if(isLegal(board, x+1,  y ) && board[x+1][ y ]=='M') mines++;
        if(isLegal(board, x+1, y+1) && board[x+1][y+1]=='M') mines++;

        if(mines != 0)
            board[x][y] = (char)(mines+'0');
        else {
            board[x][y] = 'B';
            reveal(board, x-1, y-1);
            reveal(board, x-1,  y );
            reveal(board, x-1, y+1);
            reveal(board,  x , y-1);
            reveal(board,  x , y+1);
            reveal(board, x+1, y-1);
            reveal(board, x+1,  y );
            reveal(board, x+1, y+1);
        }
    }
};