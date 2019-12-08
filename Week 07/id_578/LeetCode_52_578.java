package com.hand.week7;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/12/1
 */
public class LeetCode_52_578 {
    int size;
    int count;

    public int totalNQueens(int n) {
        size = n;
        count = 0;
        dfs(0, 0, 0, 0);
        return count;
    }

    private void dfs(int row, int col, int pie, int na) {
        if (row == size) {
            count++;
            return;
        }
        int bits = (~(col | pie | na) & ((1 << size) - 1));
        while (bits != 0) {
            int p = bits & (-bits);
            dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            bits &= (bits - 1);
        }
    }
}
