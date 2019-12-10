/**
 * @author eazonshaw
 * @date 2019/11/17  21:35
 *
 * 题目：221.最小正方形
 */
public class LeetCode_221_243 {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] states = new int[m][n];
        //处理边界值
        states[0][0] = matrix[0][0] == '0'? 0 : 1;
        //定义最长边长
        int max_side = states[0][0];
        for(int row = 1;row < m;row++){
            states[row][0] = matrix[row][0] == '0'? 0 : 1;
            max_side = Math.max(max_side,states[row][0]);
        }
        for(int col = 1;col < n;col++){
            states[0][col] = matrix[0][col] == '0'? 0 : 1;
            max_side = Math.max(max_side,states[0][col]);
        }
        for(int row = 1;row < m;row++){
            for(int col = 1;col < n;col++){
                states[row][col] = matrix[row][col] == '0'?
                        0 : Math.min(Math.min(states[row-1][col],states[row-1][col-1]),states[row][col-1]) + 1;
                max_side = Math.max(max_side,states[row][col]);
            }
        }
        return max_side*max_side;
    }

}

//动态规划，子问题，f(i,j) = matrix(i,j) == 0 ? 0 : min(f(i-1,j),f(i-1,j-1),f(i,j-1))+1
//再设置一个变量记录最大边长值 max_side
