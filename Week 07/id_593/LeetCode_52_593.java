/**
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 链接：https://leetcode.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 撇 /
 * <p>
 * 捺 \
 *
 * @author jaryoung
 */
public class LeetCode_52_593 {
    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0, 0);
    }

    private int dfs(int n, int row, int col, int pie, int na, int count) {
        if (row == n) {
            return count + 1;
        }
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        // ~(col | pie | na) -> 1111 1111 这里很好理解，与操作，就是 列 、撇 和 捺 各自来站位
        // (1 << n)          -> 0001 0000
        // ((1 << n) - 1)    -> 0000 1111 清除因为取反后的前四位的1111
        //      1111 1111
        //      0000 1111
        // bits 0000 1111  最后，得到能站的位置
        while (bits != 0) {
            //           0000 1111
            //         & 1111 0001
            // position  0000 0001
            // 取得当前能站的位置
            int position = bits & -bits;
            // 不断打掉 bits 的最后一位 1
            bits = bits & (bits - 1);
            count = dfs(n, row + 1, col | position, (pie | position) << 1, (na | position) >> 1, count);
        }
        return count;
    }

}
