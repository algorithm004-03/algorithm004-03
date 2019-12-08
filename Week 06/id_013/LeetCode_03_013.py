"""
第三题：547. 朋友圈
"""


class Solution:
    def _union(self, p, i, j):
        p1 = self._parent(p, i)
        p2 = self._parent(p, j)
        p[p2] = p1

    def _parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:
            x = i
            i = p[i]
            p[x] = root
        return root

    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M:
            return 0

        n = len(M)
        p = [i for i in range(n)]

        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    self._union(p, i, j)

        return len(set([self._parent(p, i) for i in range(n)]))


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        visited, ans = set(), 0

        def dfs(i):
            for j in range(len(M[i])):
                if M[i][j] and j not in visited:
                    visited.add(j)
                    dfs(j)

        for i in range(len(M)):
            if i not in visited:
                dfs(i)
                ans += 1
        return ans
