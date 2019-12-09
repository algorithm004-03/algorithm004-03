import java.util.ArrayList;
import java.util.List;

/**
 * @author northleaf
 * @create 2019年11月25日
 */
public class LeetCode_51_598 {
    boolean[][] board;
    List<List<String>> ans;

    public List<List<String>> solveNQueens1(int n) {
        board = new boolean[n][n];
        ans = new ArrayList<>();

        solveNQueens1(0,n, board);

        return ans;

    }

    private void solveNQueens1(int row, int n, boolean[][] board) {
        //终止条件
        if(row>=n){
            addSolution1(board,n);
            return;
        }
        //遍历处理
        for(int col = 0;col<n;col++){
            //判断是否合法
            if(isValid1(board,row,col,n)){
                //合法则将其设置为true
                board[row][col] = true;
                //下钻
                solveNQueens1(row+1,n,board);
                //回溯
                board[row][col] =false;
            }
        }
    }

    private void addSolution1(boolean[][] board, int n) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<n;j++){
                sb.append(board[i][j] ? "Q" :".");
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }

    private boolean isValid1(boolean[][] board, int row, int col, int n) {

        //检查列是否在攻击范围内
        for(int i = 0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        //检查左对角线是否在攻击范围内
        for(int i = row -1,j = col +1;i>=0&& j<n;i--,j++){
            if(board[i][j]){
                return false;
            }
        }

        //检查右对角线是否在攻击范围内
        for(int i = row -1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }

        return true;
    }

}
