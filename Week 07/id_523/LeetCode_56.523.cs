/**
 * Definition for an interval.
 * public class Interval {
 *     public int start;
 *     public int end;
 *     public Interval() { start = 0; end = 0; }
 *     public Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution
{
    public IList<Interval> Merge(IList<Interval> intervals)
    {
        var result = new List<Interval>();
        if (intervals.Count == 0) return result;

        intervals = intervals.OrderBy(q => q.start).ToList();

        int start = intervals[0].start;
        int end = intervals[0].end;

        foreach (var interval in intervals)
        {
            if (interval.start <= end)
            {
                end = Math.Max(interval.end, end);
            }
            else
            {
                result.Add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.Add(new Interval(start, end));

        return result;
    }
}