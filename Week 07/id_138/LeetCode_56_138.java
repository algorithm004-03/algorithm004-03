import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 	合并区间
 *	 给出一个区间的集合，请合并所有重叠的区间。
 * @author L
 *
 */
public class LeetCode_56_138 {
	class Interval{
		int start;
		int end;
		
		public Interval() {
		
		}
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	//自定义排序器
	private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        //排序
    	Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            //如果为空或者存在交叉
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
}
