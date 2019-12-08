/**
 * @author eazonshaw
 * @date 2019/11/3  16:39
 *
 * 题目：220.岛屿数量
 *
 * 描述：给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 例子:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 *
 * 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
 *
 */
public class LeetCode_220_243 {

    public int numIslands(char[][] grid) {

        //临界值判断
        if(grid == null || grid.length == 0){
            return 0;
        }

        //x轴
        int x = grid[0].length;
        //y轴
        int y = grid.length;
        //返回值
        int nums = 0;


        //双循环
        for(int y_now = 0;y_now < y;y_now ++){
            for(int x_now = 0;x_now < x;x_now ++){
                //如果遇到岛屿，则记录
                if(grid[y_now][x_now] == '1'){
                    nums++;
                    //下沉周围的岛屿
                    dfs(grid,x_now,y_now);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int x_now, int y_now) {
        //终止条件
        //判断是否越界
        int x = grid[0].length;
        int y = grid.length;
        if(x_now>=x || y_now>=y || x_now<0 || y_now<0){
            return;
        }

        //判断当前坐标是否为岛屿
        if(grid[y_now][x_now] == '0'){
            return;
        }

        //执行当前层逻辑，下沉岛屿
        grid[y_now][x_now] = '0';

        //下坠，继续判断当前位置的上下左右坐标
        dfs(grid,x_now,y_now-1);
        dfs(grid,x_now,y_now+1);
        dfs(grid,x_now-1,y_now);
        dfs(grid,x_now+1,y_now);

    }


}
