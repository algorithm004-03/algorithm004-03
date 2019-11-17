/**
 * 扫雷游戏
 */
public class LeetCode_529_648 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];int col = click[1];
        int m = board.length;int n = board[0].length;
        if(board[row][col]=='M'){
            board[row][col]='X';
            return board;
        }
        int count =0;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(i==0&&j==0)continue;
                int r = row+i;int c=col+j;
                System.out.println(""+r+","+c);
                if(r>=m||r<0||c<0||c>=n)continue;
                if(board[r][c]=='M'||board[r][c]=='X'){
                    count++;
                }
            }
        }
        if(count>0){
            board[row][col]=(char)(count+'0');
        }else {
             board[row][col] = 'B';
            for(int i=-1;i<2;i++){
                for(int j=-1;j<2;j++){
                    if(i==0&&j==0)continue;
                    int r = row+i;int c=col+j;
                    if(r>=m||r<0||c<0||c>=n)continue;
                    if(board[r][c]=='E')updateBoard(board,new int[]{r,c});
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        LeetCode_529_648 leetCode_529_648 = new LeetCode_529_648();
        String str = "EEEEE&EEMEE&EEEEE& EEEEE";
        LeetCode_200_648 leetCode_200_648 = new LeetCode_200_648();
        char[][] board = leetCode_200_648.buildArray(str);
        int[] click = new int[]{3,1};
        char[][] board2 = leetCode_529_648.updateBoard(board,click);
        leetCode_200_648.printArray(board);

    }
}
