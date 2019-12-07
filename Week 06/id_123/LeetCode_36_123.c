
bool isValidSudoku(char** board, int boardRowSize, int boardColSize) {
    bool row[9][10]={0}; //表示某行某数是否被检索过
    bool col[9][10]={0};  //表示某列某数是否被检索过
    bool block[9][10]={0}; //表示某块某数是否被检索过
    
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            if(board[i][j]=='.') continue;
            int num=board[i][j]-'0';
            if(row[i][num] || col[j][num] || block[i/3*3+j/3][num]){ 
                return false;
            }else{
                row[i][num]=true;
                col[j][num]=true;
                block[i/3*3+j/3][num]=true;
            }
        }
    }
    return true;
    
}