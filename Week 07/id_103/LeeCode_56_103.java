/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int length=intervals.length;
    	if(length==0){
    		return intervals;
    	}
    	Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0]-arg1[0];
			}   		
		});
    	List<int[]> list=new ArrayList<>();
    	int i=0;
    	while(i<length){
    		// 从i开始，不断吞并后续波段，直到不能吞并
    		int[] now=new int[2];
    		now[0]=intervals[i][0];
    		int max=intervals[i][1];
    		while(i+1<length&&max>=intervals[i+1][0]){
    			// 如果能吞并，则i++，直到波段i不能吞并波段i+1
    			if(max<intervals[i+1][1]){
    				max=intervals[i+1][1];
    			}
    			i++;
    		}
    		now[1]=max;
    		list.add(now);		
    		i++;
    	}           	
    	return list.toArray(new int[][]{});
    }
}
// @lc code=end

