import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/11/4
 */
public class LeetCode_51_368 {

    /*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    https://leetcode-cn.com/problems/n-queens/*/

    public static void main(String[] args) {

    }

    // 存放可攻击到的列
    private Set<Integer> col = new HashSet<>();
    // 存放可攻击到的左斜线
    private Set<Integer> left = new HashSet<>();
    // 存放可攻击到的右斜线
    private Set<Integer> right = new HashSet<>();
    // result
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        solve(n, 0, new LinkedList<>());
        return res;
    }

    public void solve (int n, int row, LinkedList<Integer> current) {
        // terminator
        if (row == n) {
            res.add(cover(current, n));
            return;
        }

        // process current logic
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !left.contains(row + i) && !right.contains(row - i)) {
                current.add(i);
                col.add(i);
                left.add(row + i);
                right.add(row - i);
                // drill down
                solve(n, row + 1, current);
                // reverse state
                current.remove();
                col.remove(i);
                left.remove(row + i);
                right.remove(row + i);
            }
        }
    }

    public List<String> cover(List<Integer> current, int n){
        List<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < current.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (current.get(i) == j) {
                    s.append(".");
                } else {
                    s.append("Q");
                }
            }
            result.add(s.toString());
        }
        return result;
    }
}
