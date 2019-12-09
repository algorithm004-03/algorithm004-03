class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        n = len(cost)
        if n==2:
            return min(cost)
        
        p = cost[0]
        q = cost[1]
        for i in range(2,n):
            next_ = min(p,q) + cost[i]
            p = q
            q = next_  
        return min(p,q)