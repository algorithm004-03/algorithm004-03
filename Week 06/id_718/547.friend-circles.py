#
# @lc app=leetcode id=547 lang=python3
#
# [547] Friend Circles
#

# @lc code=start
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M:
            return 0
        # union find
        def parent(p,i):
            root = i
            while p[root] != root:
                root = p[root]
            while p[i] != i:
                x = i; i = p[i]; p[x] = root
            return root

        def union(p, i, j):
            p1, p2 = parent(p, i), parent(p, j)
            p[p2] = p1
        
        n = len(M)
        p = [i for i in range(n)]
        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    union(p, i, j)
        
        return(len(set([parent(p, i) for i in range(n)])))
        
# @lc code=end

