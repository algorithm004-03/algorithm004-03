class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
        int i =0 ;
        while( i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length - 1 && right >= intervals[i+1][0]) {
                right = intervals[i+1][1] > right ? intervals[i+1][1] : right;
                i++;
            }
            res.add(new int[]{left , right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
