import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

// 思路:
// 先按首位置进行排序;
// 接下来,如何判断两个区间是否重叠呢?比如 a = [1,4],b = [2,3]
// 当 a[1] >= b[0] 说明两个区间有重叠.
// 但是如何把这个区间找出来呢?
// 左边位置一定是确定，就是 a[0]，而右边位置是 max(a[1], b[1])
// 所以,我们就能找出整个区间为:[1,4]

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length==0 || intervals==null)
            return res.toArray(new int[0][]);
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int i=0;
        while(i<intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i<intervals.length-1 && intervals[i+1][0]<=right){
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
// @lc code=end

