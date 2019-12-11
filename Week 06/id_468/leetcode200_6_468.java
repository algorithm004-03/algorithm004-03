package week6;

/**
 * @program: leetcode
 * @description: 孤岛问题
 * @author: 王瑞全
 * @create: 2019-11-2422:26
 **/


public class leetcode200_6_468 {
    private int n;
    private int m;
    public int findCircleNum(int[][] M) {
        int count=0;
        n=M.length;
        if(n==0)return 0;
        m=M[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==1) {
                    DFS(M, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFS(int[][] grid,int i,int j){
        if(i<0||j<0||i>=n||j>=m||grid[i][j]!=1) return ;
        grid[i][j]=0;
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);
    }
}
