import java.util.*;

/**
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals
 */
public class LeetCode_56_588 {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (null == intervals || 0 == intervals.length) {
            return result.toArray(new int[0][]);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i ++;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{left, right});
            i ++;
        }
        return result.toArray(new int[0][]);
    }

}
