package week3;

/**
 * @program: leetcode
 * @description: Minesweeper
 * @author: 王瑞全
 * @create: 2019-11-0317:28
 **/


public class leetcode529_3_468 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x=click[0];
        int y=click[1];

        if(board[x][y]=='M'){
            board[x][y]='X';
            return board;
        }
        int count=countMines(board,x,y);

        if(count>0){
            board[x][y]=(char)(count+'0');
        }
        else{
           updateBoard(board,x,y);
        }
        return board;
    }

    public void updateBoard(char[][] board,int x,int y){
        if(x<0||y<0||y>=board[0].length||x>=board.length) return;
        int count=countMines(board,x,y);
        if(board[x][y]=='E'){
            if(count == 0) {
                board[x][y] = 'B';
                for(int i = Math.max(x-1 , 0) ; i <= Math.min(x+1 , board.length-1) ; i++) {
                    for(int j = Math.max(y-1 , 0) ; j <= Math.min(y+1 , board[0].length-1) ; j++) {
                        updateBoard(board , i , j);
                    }
                }
            }
            else {
                board[x][y]=(char)(count+'0');
            }
        }

    }
    //计算位置相邻的地雷数量
    public int countMines(char[][] board,int x,int y ){
        int N=board.length;
        int M=board[0].length;
        int count=0;
        for(int i=Math.max(x-1,0);i<=Math.min(x+1,N-1);i++){
            for(int j=Math.max(y-1,0);i<Math.min(y+1,M-1);j++){
                if(board[i][j]=='M'){
                   count++;
                }
            }
        }
        return count;
    }
}
