import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 * 排序所有区间，然后从前到后合并
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[0] - b[0]));
        List<int[]> temp = new ArrayList<int[]>();
        int[] lasteValue = new int[2];
        for(int[] value : intervals ){
            if(temp.isEmpty()){
                temp.add(value);
                lasteValue = value;
            }

            if(lasteValue[1] >= value[0]){
                lasteValue[1] = Math.max(value[1],lasteValue[1]);
            }else{
                temp.add(value);
                lasteValue = value;
            }
        }
        int[][] result = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;

    }
}
// @lc code=end

