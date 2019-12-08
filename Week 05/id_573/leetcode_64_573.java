<<<<<<< HEAD
public class SolutionFive {    public int minPathSum(int[][] grid) {        int[][] dp = new int[grid.length][grid[0].length];        for (int i = grid.length - 1; i >= 0; i--) {            for (int j = grid[0].length - 1; j >= 0; j--) {                if(i == grid.length - 1 && j != grid[0].length - 1)                    dp[i][j] = grid[i][j] +  dp[i][j + 1];                else if(j == grid[0].length - 1 && i != grid.length - 1)                    dp[i][j] = grid[i][j] + dp[i + 1][j];                else if(j != grid[0].length - 1 && i != grid.length - 1)                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);                else                    dp[i][j] = grid[i][j];            }        }        return dp[0][0];    }    public static void main(String[] args) {        SolutionFive solutionFive = new SolutionFive();        System.out.println(solutionFive.minPathSum(new int[3][3]{[1,3,1],[1,5,1],[4,2,1]}));    }}
=======
public class SolutionFive {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        SolutionFive solutionFive = new SolutionFive();
        System.out.println(solutionFive.minPathSum(new int[3][3]{[1,3,1],[1,5,1],[4,2,1]}));
    }
}
>>>>>>> 2b197e0935af130a7dbda536ba2b34213711c6d7
