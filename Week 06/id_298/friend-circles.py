class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M: return 0
        n = len(M)

        # 初始化集合每个元素自己单独一个集合
        p = [i for i in range(n)]
        # 遍历整个矩阵，如果M[i][j] == 1 合并i, j
        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    self._union(p, i, j)
        # 遍历parent的个数
        return len(set([self._find(p, i) for i in range(n)]))

    def _union(self, p, i, j):
        p1 = self._find(p, i)
        p2 = self._find(p, j)
        p[p2] = p1

    def _find(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]

        while p[i] != i:
            x = i
            i = p[i]
            p[x] = root

        return root
