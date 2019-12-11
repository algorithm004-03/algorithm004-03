/**
 * @author eazonshaw
 * @date 2019/11/17  20:48
 *
 * 题目：64.最小路径和
 */
public class LeetCode_64_243 {

    //从原坐标出发，当前节点的值，等于上面的值与左边的值中的较小值加上自己本身，其中要记得处理边界问题，即n==0和m==0
    //dp方程：dp(i,j) = Math.min(dp(i-1,j),dp(i,j-1))+grid[i][j]
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] states = new int[m][n];
        //处理边界问题
        states[0][0] = grid[0][0];
        for(int i = 1;i < m;i++){
            states[i][0] = states[i-1][0] + grid[i][0];
        }
        for(int j = 1;j < n;j++){
            states[0][j] = states[0][j-1] + grid[0][j];
        }
        //动态转移方程
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                states[i][j] = Math.min(states[i-1][j],states[i][j-1]) + grid[i][j];
            }
        }
        return states[m-1][n-1];
    }

    //将状态数组转为一维数组
    //dp方程为：dp(i) = Math.min(dp(i-1),dp(i))+grid[j][i]
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] states = new int[n];
        //初始化
        states[0] = grid[0][0];
        for(int col = 1;col < n;col++){
            states[col] = states[col-1] + grid[0][col];
        }
        //dp
        for(int row = 1;row < m;row++){
            for(int col = 0;col < n;col++){
                states[col] = col == 0?states[col] + grid[row][col]:Math.min(states[col-1],states[col])+grid[row][col];
            }
        }
        return states[n-1];
    }
}

