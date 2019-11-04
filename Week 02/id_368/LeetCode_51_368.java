import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_51_368 {

    /*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    https://leetcode-cn.com/problems/n-queens/*/

    public static void main(String[] args) {

    }

    private Set<Integer> col;
    private Set<Integer> left;
    private Set<Integer> right;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;
        col = new HashSet<>();
        left = new HashSet<>();
        right = new HashSet<>();
        solve(n, 0, new ArrayList<Integer>());
        return res;
    }

    public void solve(int n, int row, List<Integer> current){
        if (row == n) {
            res.add(cover(current));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !left.contains(row + i) && !right.contains(row - i)) {
                current.add(i);
                col.add(i);
                left.add(row + i);
                right.add(row - i);
                solve(n, row + 1, current);
                col.remove(i);
                left.remove(row + i);
                right.remove(row - i);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<String> cover(List<Integer> current){
        List<String> result = new ArrayList<>();
        for (int num : current) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < current.size(); i++) {
                if (num == i) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            result.add(s.toString());
        }
        return result;
    }
}
