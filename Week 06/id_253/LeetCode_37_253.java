class Solution {
    int n =3 ;
    int N = n* n ;
    int[][] row = new int[N][N+1];
    int[][] col = new int[N][N+1];
    int[][] boxes = new int[N][N+1];
    char[][] board;
    boolean sudokuSolved = false;
    public boolean couldPlace(int d ,int i , int j ){
        int idx = (i/3)*3 + j/3;
        return row[i][d]+col[j][d]+boxes[idx][d] == 0 ;
    }
    public void placeNumber(int d , int i ,int j){
        int idx  =  (i/3)*3 + j/3;
        row[i][d]++;
        col[j][d]++;
        boxes[idx][d]++;
        board[i][j] = (char)(d+'0');
    }
    public void removeNumber(int d , int i ,int j){
        int idx = (i/3)*3 + j /3;
        row[i][d]--;
        col[j][d]--;
        boxes[idx][d]--;
        board[i][j] = '.';
    }
    public void placeNextNumbers(int i , int j){
        if((i == N-1) && (j == N-1)) sudokuSolved = true;
        else{
            if(j == N - 1) backtrack(i+1,0);
            else{
                backtrack(i , j+1);
            }   
        }
    }
    public void backtrack(int x , int y){
        if(board[x][y] == '.'){
                for(int d = 1 ; d <= 9 ; d++){
                    if(couldPlace(d,x,y)){
                        placeNumber(d,x,y);
                        placeNextNumbers(x,y);
                        if(!sudokuSolved) removeNumber(d,x,y);
                    }  
            }
        }
        else placeNextNumbers(x,y);
    }
    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i = 0 ;  i < 9  ; i++){
            for(int j = 0 ; j < 9 ; j ++){
                if(board[i][j] != '.'){
                    int d = Character.getNumericValue(board[i][j]);
                    placeNumber(d,i,j);
                }
            }
        }
        backtrack(0,0);
    }
}
