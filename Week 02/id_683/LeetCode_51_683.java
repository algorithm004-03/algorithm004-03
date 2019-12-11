import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();


    public List<List<String>> solveNQueens(int n) {

        backtrack(n, 0, new ArrayList<Integer>());

        List<List<String>> res = new ArrayList<>();

        for (List<Integer> cur : result) {
            List<String> solution = new ArrayList<>();
            for (int index : cur) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; ++i) {
                    if (index == i) {
                        sb.append("Q");
                        continue;
                    }
                    sb.append(".");
                }
                solution.add(sb.toString());
            }
            res.add(solution);
        }
        return res;
    }

    private void backtrack(int n, int row, List<Integer> cur_state) {
        if (row == n) {
            result.add(cur_state);
            return;
        }

        for (int i = 0; i < n; ++i) {
            // check if can place queen in here
            if (cols.contains(i) || pie.contains(row - i) || na.contains(row + i)) {
                continue;
            }

            // place queen and add place where it can attack
            cols.add(i);
            pie.add(row - i);
            na.add(row + i);
            
            List<Integer> newCur = new ArrayList<Integer>(cur_state);
            newCur.add(i);
            backtrack(n, row + 1, newCur);

            // revert state
            cols.remove(i);
            pie.remove(row - i);
            na.remove(row + i);
        }
    }
}