/**
 * @Date 2019/11/17
 **/
public class LeetCode_34_648 {

    public int minPathSum(int[][] grid) {
       int minPath = 0;
       int[] dp = new int[grid.length+1];
       for(int i=grid.length-1;i>=0;i--){
           for(int j=grid[i].length-1;j>=0;j--){
               if(i==grid.length-1&&j!=grid[i].length-1){
                   dp[j] =grid[i][j]+dp[j+1];
               }else if(i!=grid.length-1&&j==grid[i].length-1){
                   dp[j] =grid[i][j]+dp[j];
               }else if(i!=grid.length-1&&j!=grid[i].length-1){
                   dp[j] =grid[i][j]+Math.min(dp[j+1],dp[j]);
               }else {
                   dp[j] = grid[i][j];
               }
           }
       }
        return dp[0];
    }
    public int minPathSum2(int[][] grid) {
        return calculate(grid,0,0);
    }

    private int calculate(int[][] grid,int i,int j){
        if(i==grid.length||j==grid[0].length){return Integer.MAX_VALUE;}
        if(i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j]+Math.min(calculate(grid,i+1,j),calculate(grid,i,j+1));
    }

    public static void main(String[] args) {
        LeetCode_34_648 leetCode_34_648 = new LeetCode_34_648();
        int[][] grid = new int[3][3];
        grid[0]=new int[]{1,3,1};
        grid[1]=new int[]{1,5,1};
        grid[2]=new int[]{4,2,1};
        System.out.println(leetCode_34_648.minPathSum2(grid));
    }
}
