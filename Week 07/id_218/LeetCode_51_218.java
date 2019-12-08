package leetcode.week7;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * @author eason.feng at 2019/12/1/0001 15:04
 **/
public class LeetCode_51_218 {

    private int size;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~ (row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }


}
