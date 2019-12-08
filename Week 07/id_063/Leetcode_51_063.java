/*

采用位运算的方式维护当前棋盘上面的占位信息
colMask表示当前行之前所有行上填的皇后已经占的列数，每一位代表一列
ldMask表示当前行上被前面所有皇后左对角线占用的列
rdMask表示当前行上被前面所有皇后右对角线占用的列

可以巧妙用或运算快速算出当前行剩余可以填的列有哪些

到最后如果所有列能填满, 说明找到一种方案

 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private String getStr(int row, int n) {
        int mask = (1 << (n-1));
        StringBuilder builder = new StringBuilder();

        while (mask != 0) {
            builder.append(((row & mask) != 0) ? "Q" : ".");
            mask >>= 1;
        }

        return builder.toString();
    }

    void dfs(int col, int ldMask, int rdMask, int n, List<List<String>> ans, List<Integer> path) {
        //System.out.println(String.format("%x", col));
        if (col == (1<<n) - 1) {
            List<String> l = new ArrayList<>(n);
            for (Integer row : path) {
                l.add(getStr(row, n));
            }
            ans.add(l);
            return;
        }

        int validPos = (~((col | ldMask | rdMask))) & ((1<<n) - 1);
        //System.out.println(String.format("pos = %x", validPos));
        if (validPos == 0) {
            // 全0代表没有可以填的位置
            return;
        }

        int newPos = 0;
        while (validPos != 0) {
            newPos = validPos & (-validPos);
            validPos = validPos & (validPos - 1);

            path.add(newPos);
            dfs(col | newPos, (ldMask | newPos) << 1, (rdMask | newPos) >> 1, n, ans, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();

        dfs(0, 0, 0, n, ans, new ArrayList<>(n));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( new Solution().solveNQueens(8) );
    }
}
