package id_713;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 */
public class LeetCode_56_MergeIntervals {
    /*
    给出一个区间的集合，请合并所有重叠的区间。

    示例 1:

    输入: [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

    示例 2:

    输入: [[1,4],[4,5]]
    输出: [[1,5]]
    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-intervals
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // 升序排序
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[1]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
