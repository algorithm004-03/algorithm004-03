class Solution(object):
    def merge(self, intervals):
        """
        合并区间：https://leetcode-cn.com/problems/merge-intervals/
        
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(intervals) <= 1:
            return intervals
        # 对intervals进行排序
        intervals.sort(key = lambda x: x[0])
        # 排序完后，扫描intervals，如果扫描元素和前一个元素有交集，则扩大前一个元素的区间，否则则加入到结果中
        result = []
        k = 0
        for i in range(1, len(intervals)):
            if intervals[i][0] <= intervals[k][1]:
                if intervals[i][1] > intervals[k][1]:
                    intervals[k][1] = intervals[i][1]
            else:
                result.append(intervals[k])
                k = i
        # 最后的一次不在循环内判断，需要单独加入
        result.append(intervals[k])
        return result






