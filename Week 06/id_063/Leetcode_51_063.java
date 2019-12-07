/*
思路

递归求解，没什么可说的，注意横竖和斜线上是否有皇后，进行减枝回溯即可
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<String> choice2str_list(int[] choice) {
        List<String> retList = new ArrayList<>(choice.length);
        String initString = "";
        for (int i = 0; i < choice.length; i++) initString = initString + ".";

        for (int queuePos : choice) {
            StringBuilder s = new StringBuilder(initString);
            s.setCharAt(queuePos, 'Q');
            retList.add(s.toString());
        }

        return retList;
    }

    private List<List<String>> dfs(List<List<String>> result, int[] choice, int curLevel, int maxLevel) {
        if (curLevel == maxLevel) {
            result.add(choice2str_list(choice));
            return result;
        }

        for (int cur_j = 0; cur_j < maxLevel; cur_j++) {
            boolean conflict = false;
            for (int i = 0; i < curLevel; i++) {
                // 列冲突
                if (choice[i] == cur_j) {
                    conflict = true;
                    break;
                }

                // 对角线冲突
                if (Math.abs(curLevel -i) == Math.abs(cur_j-choice[i])) {
                    conflict = true;
                    break;
                }
            }

            if (conflict) {
                continue;
            }

            choice[curLevel] = cur_j;
            dfs(result, choice, curLevel + 1, maxLevel);
        }

        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        return dfs(new LinkedList<List<String>>(), new int[n], 0, n);
    }
}
