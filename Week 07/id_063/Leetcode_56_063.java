/*

思路
排序所有区间，然后从前到后合并

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> ans = new ArrayList<>();

        for (int[] val : intervals) {
            if (ans.isEmpty()) {
                ans.add(val);
                continue;
            }

            int[] lastVal = ans.get(ans.size()-1);
            if (val[0] <= lastVal[1]) {
                lastVal[1] = Math.max(lastVal[1], val[1]);
            } else {
                ans.add(val);
            }
        }

        int[][] ret = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }

        return ret;
    }
}