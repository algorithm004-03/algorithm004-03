package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 200. 岛屿数量  https://leetcode-cn.com/problems/number-of-islands/
 * @Date 2019/11/01
 */
public class LeetCode_200_693 {
    //实录：沉到模式
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int i,int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid,i - 1,j);
            dfs(grid,i + 1,j);
            dfs(grid,i,j + 1);
            dfs(grid,i,j - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_200_693().numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
       System.out.println(new LeetCode_200_693().numIslands(new char[][]{{'1'},{'1'}}));
        System.out.println(new LeetCode_200_693().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}
