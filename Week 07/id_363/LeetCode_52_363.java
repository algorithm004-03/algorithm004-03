package com.test.leetcode.week07;

import org.junit.Test;


public class SolutionNQueensii52 {


    @Test
    public void test1() {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(8));
        System.out.println(totalNQueens_2(4));
        System.out.println(totalNQueens_2(8));

    }


    /**
     * 返回n皇后不同解法的数量
     * 位运算
     * ld rd 中的1 表示左斜线/右斜线 哪些位置不能放
     * @param n
     * @return
     */
    int res;
    public int totalNQueens(int n) {
        int col = 0, ld = 0, rd = 0;
        res = 0;
        helper(0, n, col, ld, rd);
        return res;
    }

    private void helper(int r, int n, int col, int ld, int rd) {
        // termiantion
        if (r == n) {
            res ++;
            return;
        }
        // process
        int bits = ~(col | ld | rd) & ((1 << n) - 1);
        // drill down
        while (bits != 0) {
            int pick = bits & (-bits); // 保留最后一个1,其他1变为0
            helper(r + 1, n, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
            bits &= (bits - 1); // 最后一个1赋值为0
        }
        // reverse
    }



    int[] cols;
    int[] pie;
    int[] na;
    int[] queens;
    int count;
    public int totalNQueens_2(int n) {
        // 初始化
        count = 0;
        queens = new int[n];
        cols = new int[n];
        pie = new int[2 * n + 1];
        na = new int[2 * n + 1];
        // 递归
        helper_20191130(0, n);
        // 返回
        return count;

    }

    private void helper_20191130(int r, int n) {
        // termiantion
        if (r == n) {
            count ++;
            return;
        }
        // process
        for (int c = 0; c < n; c ++) {
            if (cols[c] + pie[r + c] + na[ r - c + n] == 0) {
                cols[c] = 1;
                pie[r + c] = 1;
                na[r - c + n] = 1;
                queens[r] = c;
                helper_20191130(r + 1, n);
                cols[c] = 0;
                pie[r + c] = 0;
                na[r - c + n] = 0;
                queens[r] = 0;
            }
        }
        // drill down
        // reverse

    }


}
