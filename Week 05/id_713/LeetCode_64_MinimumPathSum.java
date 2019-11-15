package id_713;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode_64_MinimumPathSum {

    /*
    思路:
    1. 套用 路径计数的思路, 从右下角出发, 把左边和上面都加起来, 左边=左边+出发点, 上边=上边+出发点
    2. 问题在于: 不是计数器了, 需要在 除了最下一行,除了最右一列的 二维坐标中找最小值


    1   3   1
    1   5   1
    4   2   1
    从右下的1出发,
        如果是最右列, 则累加
        如果是最下行, 则累加
        如果不是右列 也不是最下行, 则选取 右边 和 左边中最小的 累加


     */

    public int minPathSum(int[][] grid) {
        int row = grid.length - 1;
        int col = grid[0].length - 1;

        for (int i = row; i >= 0; i--) {
            for (int j = col; j >= 0; j--) {
                // 最下行
                if (i == row && j != col)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                    // 最右列
                else if (i != row && j == col)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                    // 中间的坐标
                else if (i != row && j != col) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);

                }
            }
        }

        return grid[0][0];
    }

}