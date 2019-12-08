/**
 * @author northleaf
 * @create 2019年11月14日
 */
public class LeetCode_62_598 {


    /**
     * 递归的方式处理
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {

        //m -1 n-1 要考虑数组是从0开始的
        return helper(0, 0, m-1, n-1);

    }

    private int helper(int row, int col, int rowMax, int colMax) {


        //终止条件
        if(row==rowMax && col == colMax){
            return 1;
        }

        //处理当前层
        //处理下一层
        int leftRes = 0;
        int right = 0;
        //行
        if(row<rowMax){
            leftRes = helper(row +1,col,rowMax,colMax);
        }
        //列
        if(col < colMax){
            right = helper(row,col+1,rowMax,colMax);
        }

        //清理数据

        return leftRes+right;
    }


    /**
     * 使用记忆化搜索的方式，类似于缓存
     *  此题的起始点为右下角
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] op = new int[m][n];
        for(int i = 0;i<n;i++){
            op[0][i] = 1;
        }
        for(int i = 0;i<m ;i++){
            op[i][m] =0;
        }
        for (int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                op[i][j] = op[i-1][j]+op[i][j-1];
            }
        }
        //m -1 n-1 要考虑数组是从0开始的
        return op[m-1][n-1];

    }
}
