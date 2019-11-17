package com.test.leetcode.week03;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * done 20191103
 * todo 20191104
 * todo 20191105
 * todo 20191109
 */
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

//        System.out.println(numIslands(grid));
//        System.out.println(numIslands(grid2));

//        System.out.println(numIslands_bfs(grid));
//        System.out.println(numIslands_bfs(grid2));

        char[][] grid3 = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numIslands_bfs(grid3));

    }


    /**
     * 1.DFS: 遇到1，那么递归吧这个1周边的1全部置为0
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c ++) {
                if (grid[r][c] == '1') {
                    ++ num;
                    helper(grid, r, c);
                }
            }
        }
        return num;
    }

    private void helper(char[][] grid, int r, int c) {
        // termination
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0') {
            return;
        }
        // process
        grid[r][c] = '0';
        // drill down
        helper(grid, r - 1, c);
        helper(grid, r + 1, c);
        helper(grid, r , c - 1);
        helper(grid, r , c + 1);
        // reverse
    }


    /**
     * bfs: 发现1，将这个1旁边所有有可能的1都加入到队列中
     * @param grid
     * @return
     */
    public int numIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;
        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c ++) {
                if (grid[r][c] != '1') {
                    continue;
                }
                ++nums ;
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(r * nc + c);
                while(!queue.isEmpty()) {
                    Integer cur = queue.poll();
                    int row = cur / nc;
                    int col = cur % nc;
                    grid[row][col] = '0';

                    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                        queue.add((row - 1) * nc + col);
                    }
                    if (row + 1 < nr && grid[row + 1][col] == '1') {
                        queue.add((row + 1) * nc + col);
                    }

                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        queue.add(row * nc + col - 1);
                    }

                    if (col + 1 < nc && grid[row][col + 1] == '1') {
                        queue.add(row * nc + col + 1);
                    }
                }
            }
        }
        return nums;
    }

}
