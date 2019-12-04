class Solution {
public:
    bool solved=false;
    //二维数组的行记录board一行或一列或一个宫
    bool row[10][10],col[10][10],box[10][10];
    void solveSudoku(vector<vector<char>>& board) {
        //初始化
        memset(row,false,sizeof(row));
        memset(col,false,sizeof(col));
        memset(box,false,sizeof(box));
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int index=3*(i/3)+j/3;
                int num=board[i][j]-'0';
                row[i][num]=col[j][num]=box[index][num]=true;
            }
        }
        DFS(0,0,board);
    }
    
    void DFS(int i,int j,vector<vector<char>>& board){
        if(solved==true)
            return;
        if(i>=9){
            solved=true;
            return;
        }
        
        //board[i][j]非空，考虑下一个位置
        if(board[i][j]!='.'){
            if(j<8)
                DFS(i,j+1,board);
            else if(j==8)
                DFS(i+1,0,board);
            if(solved==true)
                return;
        }
        
        //board[i][j]为空，可以填数
        else{
            int index=3*(i/3)+j/3;
            for(int num=1;num<=9;num++){
                if(!row[i][num]&&!col[j][num]&&!box[index][num]) //num是否符合规则
                {   board[i][j]=num+'0'; //填数
                    row[i][num]=col[j][num]=box[index][num]=true; 
                    
                    if(j<8)   //递归
                        DFS(i,j+1,board);    
                    else if(j==8)
                        DFS(i+1,0,board);
                    
                    if(!solved){     //回溯
                        row[i][num]=col[j][num]=box[index][num]=false; 
                        board[i][j]='.';
                    }
                     
                }
            }
        }
    }
};
