/*
 * @lc app=leetcode.cn id=52 lang=java
 * 采用位运算的方式维护当前棋盘上面的占位信息
 * colMask表示当前行之前所有行上填的皇后已经占的列数，每一位代表一列
 * lMask表示当前行上被前面所有皇后左对角线占用的列,rMask表示当前行上被前面所有皇后右对角线占用的列
 * 可以巧妙用位运算快速算出当前行剩余可以填的列有哪些,到最后如果所有列能填满, 说明找到一种方案
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    void dfs(int col, int lMask, int rMask, int n, int[] totalCnt) {
        //终止条件
        if (col == (1<<n) - 1) {
            totalCnt[0]++;
            return;
        }

        int validPos = (~((col | lMask | rMask))) & ((1<<n) - 1);
        if (validPos == 0) {
            return;
        }
        int newPos = 0;
        while (validPos != 0) {
            newPos = validPos & (-validPos);
            validPos = validPos & (validPos - 1);
            dfs(col | newPos, (lMask | newPos) << 1, (rMask | newPos) >> 1, n, totalCnt);
        }
    }

    public int totalNQueens(int n) {
        int[] ans = new int[] {0};
        dfs(0, 0, 0, n, ans);
        return ans[0];
    }
}
// @lc code=end

