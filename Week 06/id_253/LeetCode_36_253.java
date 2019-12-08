class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer , Integer>[] row = new HashMap[9];
        HashMap<Integer , Integer>[] col = new HashMap[9];
        HashMap<Integer , Integer>[] boxes = new HashMap[9];
        for(int i  =0  ; i < 9 ; i++){
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for(int i = 0 ;i < 9 ;i++){
            for(int j =0 ; j< 9 ;j++){
                int boxnum = (i/3)*3 + j / 3;
                int n = (int)board[i][j] ;
                if(board[i][j] != '.'){
                    row[i].put(n,row[i].getOrDefault(n,0)+1);
                    col[j].put(n,col[j].getOrDefault(n,0)+1);
                    boxes[boxnum].put(n,boxes[boxnum].getOrDefault(n,0)+1);
                    if(row[i].get(n) > 1 || col[j].get(n) > 1 || boxes[boxnum].get(n) > 1) return false;
                }
            }
        }
        return true;
    }
}
