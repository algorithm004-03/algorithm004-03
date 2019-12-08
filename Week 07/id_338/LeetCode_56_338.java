import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Leesen
 * @date 2019/12/1 23:31
 */
public class LeetCode_56_338 {
    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
//            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
            return Integer.compare(a.start, b.start);
        }
    }


    public int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new LinkedList<>();
        for (int[] interval : intervals) {
            intervalsList.add(new Interval(interval));
        }
        intervalsList.sort(new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList();
        for (Interval interval : intervalsList) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int i = 0;
        int[][] result = new int[merged.size()][2];
        for (Interval interval : merged) {
            result[i++] = interval.toArray();
        }
        return result;
    }

    // 上面方法比较啰嗦, 下面这个解法很简练
    // https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
    public int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        //**** Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[][] result = new int[intervals.length][2];
        int[] newInterval = intervals[0];
        int i = 0;
        result[0] = newInterval;
        for (int[] interval : intervals) {
            if (newInterval[1] >= interval[0]) {  // Overlapping intervals, move the end if needed
                result[i][1] = Math.max(result[i][1], interval[1]);
            } else {  // Disjoint intervals, add the new interval to the list
                result[++i] = interval;
                newInterval = interval;  //**** 容易遗漏
            }
        }

        return Arrays.copyOfRange(result, 0, i+1);  //****要记住这种写法
    }
}
