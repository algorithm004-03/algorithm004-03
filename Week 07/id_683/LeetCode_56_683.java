import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        List<int[]> res = new ArrayList<>();

        Collections.sort(intervals, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
        });

        int index = 0;
        
        while (index < intervals.length) {
            int left = intervals[index][0];
            int right = intervals[index][1];

            while (index < intervals.length - 1 && right <= intervals[index + 1][0]) {
                index++;
                right = Math.max(right, intervals[index][1]);
            }
            res.add(new int[] {left, right});
            index++;
        }

        return res.toArray(new int[0][]);
    }
}