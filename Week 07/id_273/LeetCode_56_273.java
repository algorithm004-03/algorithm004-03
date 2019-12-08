//56. 合并区间

//解法1：遍历比较二维数组		执行用时：11ms
//思路：若相邻的区间, 前一位的末尾大于等于后一位的起始, 我们就可以将其合并为一个区间, 新的区间末尾为前一位末尾和后一位末尾的较大值
//时间复杂度：O(nlogn * n)
//空间复杂度：O(n)
public int[][] merge(int[][] intervals) {
	if (intervals.length == 0 || intervals == null) return intervals;
	Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	int[] temp = intervals[0];
	List<int[]> list = new ArrayList<>();
	list.add(temp);
	for (int[] interval : intervals) {
		if (interval[0] <= temp[1]) {
			temp[1] = Math.max(temp[1], interval[1]);
		} else {
			temp = interval;
			list.add(temp);
		}
	}        
	return list.toArray(new int[list.size()][]);
}