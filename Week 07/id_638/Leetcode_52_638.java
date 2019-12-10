package test1.Week7;

public class Leetcode_52_638 {

    /**
     * 八皇后2
     * @param n
     * @return
     */
    int count = 0;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        dfs(0,n,0,0,0);
        return count;
    }

    public void  dfs(int row,int n,int col,int pie,int na){
        if (row == n) {
            count ++;
            return;
        }
        //当前可以考虑放皇后的位置
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0){
            int p = bits & (-bits);//取出最低位的1
            bits = bits & (bits -1);//最低位清零
            dfs(row +1,n,col | p,(pie | p) << 1,(na | p) >> 1);

        }
    }
}
