class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board.length == 0 || board[0].length == 0 || click.length!=2) return board;
        int x = click[0];int y=click[1];int m=board.length;int n=board[0].length;
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }else{
            int[][] dirc={{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
            dfs(board,x,y,m,n,dirc);
        }
        return board;
    }
    public void dfs(char[][] board,int x,int y,int m,int n,int[][] dirc){
        if(x<0 || x>=m || y<0 || y>=n || board[x][y] != 'E') return;
        int mine = adjMine(board,x,y,m,n);
        if(mine > 0) board[x][y]=(char)(mine+'0');
        else{
            board[x][y] ='B';
            for(int[] dir : dirc){
                dfs(board,x+dir[0],y+dir[1],m,n,dirc);
            }
        }
    }
    public int adjMine(char[][] board ,int x,int y ,int m ,int n){
        int cnt=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 && j>=0 && i<m && j<n && board[i][j] == 'M'){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
