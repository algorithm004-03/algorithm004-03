class Solution(object):
    def solve(self, board):
        """
        被围绕的区域: https://leetcode-cn.com/problems/surrounded-regions/

        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 并查集解法二：


        
###################################################################

        # 并查集解法一：
        # 建立并查集
        if not board:
            return
        m = len(board)
        n = len(board[0])
        p = [i * n + j for i in range(m) for j in range(n)]
        def _find(p, i):
            root = p[i]
            while p[root] != root:
                root = p[root]
            # 压缩空间
            while p[i] != i:
                tmp = p[i]
                p[i] = root
                i = tmp
            return root
        def _union(p, i, j):
            a = _find(p, i)
            b = _find(p, j)
            # 有一个在边缘，则边缘的为root
            _a = p[a] // n
            _b = p[a] % n
            if _a == 0 or _a == m - 1 or _b == 0 or _b == n - 1:
                p[b] = a
            else:
                p[a] = b
        # 利用并查集解答
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    # 合并上下左右
                    for di in range(4):
                        new_i = i + dy[di]
                        new_j = j + dx[di]
                        if 0 <= new_i < m and 0 <= new_j < n and board[new_i][new_j] == 'O':
                            _union(p, new_i * n + new_j, i * n + j)
        
        # 遍历并查集，root不在边上的集合全部置X
        for i in range(m):
            for j in range(n):
                root = _find(p, i * n + j)
                _a = p[root] // n
                _b = p[root] % n
                if not (_a == 0 or _a == m - 1 or _b == 0 or _b == n - 1):
                    board[i][j] = 'X'
