package com.test.leetcode.week03;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;


public class ssolutionNumIsland200 {


    @Test
    public void test1() {
        char[][] grid = new char[4][5];
        for (char[] c : grid) {
            Arrays.fill(c, '0');
        }
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[0][3] = '1';
        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][3] = '1';
        grid[2][0] = '1';
        grid[2][1] = '1';


        char[][] grid2 = new char[4][5];
        for (char[] c : grid2) {
            Arrays.fill(c, '0');
        }
        grid2[0][0] = '1';
        grid2[0][1] = '1';
        grid2[1][0] = '1';
        grid2[1][1] = '1';
        grid2[2][2] = '1';
        grid2[3][3] = '1';
        grid2[3][4] = '1';

        char[][] grid3 = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};

        // 注释掉上面是因为上面的代码会修改grid的值，导致后面的代码输出都是0
        System.out.println(numIslands_20191124_2(grid));
        System.out.println(numIslands_20191124_2(grid2));
        System.out.println(numIslands_20191124_2(grid3));

    }


    /**
     * DFS
     * BFS
     * 注意是字符数组
     *
     * @param grid
     * @return
     */
    public int numIslands_20191124_1(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if (grid[r][c] == '1') {
                    count ++;
                    helper_20191124(grid, r, c);
                }
            }
        }
        return count;
    }

    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1, 0};
    private void helper_20191124(char[][] grid, int r, int c) {
        // termination
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        // process
        grid[r][c] = '0';
        // drill down
        for (int k = 0; k < 4; k ++) {
            helper_20191124(grid, r + dr[k], c + dc[k]);
        }
        // reverse
    }

    public int numIslands_20191124_2(char[][] grid) {
        int count = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length ; c ++) {
                if (grid[r][c] == '1') {
                    count ++;
                    queue.add(new int[]{r, c});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0]; int y = cur[1];
                        grid[x][y] = '0';
                        for (int k =0; k < 4; k ++) {
                            int nr = x + dx[k];
                            int nc = y + dy[k];
                            if (nr >= 0  && nr <= grid.length - 1 && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
