class Solution(object):
    def findCircleNum(self, M):
        """
        朋友圈: https://leetcode-cn.com/problems/friend-circles/
        :type M: List[List[int]]
        :rtype: int
        """
        # DFS写法2：
        # 基于这样一个事实:
        # 对于矩阵的n个人，如果[i][j]为1表示第i个人和第j个人互为朋友
        # 如果同时[j][k]为1，则表示i j k 互为朋友，可见具有传导性
        # 扫描每一个人i，在M中对i进行和其它人进行配对扫描[i][j] {j = 0...len(M)}
        # 如果[i][j] {j = 0...len(M)} 为1表示i和j互为朋友，这时候就要扫描j的朋友了
        # 所以继续递归深度扫描[j][j']  {j' = 0...len(M)}，同时标记i和j已经被扫描过了(被扫描过表示同一个朋友圈)
        # 最后扫描几次就是结果值
        n = len(M)
        visited = [0] * n
        # find all friends
        def dfs(i):
            for j in range(n):
                if M[i][j] and not visited[j]:
                    visited[j] = 1
                    dfs(j)
        cnt = 0
        for i in range(n):
            if not visited[i]:
                cnt += 1
                dfs(i)
            
        return cnt

##############################################################################

        # DFS解法1:效率慢:对矩形上半区域进行扫描，遇到1的，递归dfs该节点的行和列。
        size = len(M)

        def _dfs(i, j):
            M[i][j] = 0
            for k in range(i, size):
                new_j = k
                if 0 <= new_j < size and M[i][new_j] == 1:
                    _dfs(i, new_j)
                    for s in range(size):
                        new_i = s
                        if 0 <= new_i < size and M[new_i][new_j] == 1:
                            _dfs(new_i, new_j)


        count = 0
        for i in range(size):
            if M[i][i] == 1:
                count += 1
                _dfs(i, i)
        return count


##############################################################################
        # 并查集
        # 并查集实现
        p = [i for i in range(len(M))]
        def _find(p, i):
            root = p[i]
            while root != p[root]:
                root = p[root]
            # 路径压缩
            while i != p[i]:
                tmp = p[i]
                p[i] = root
                i = tmp
            return root
        def _union(p, i, j):
            a = _find(p, i)
            b = _find(p, j)
            p[a] = b
        # 利用并查集统计有多少个朋友圈
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j] == 1:
                    _union(p, i, j)
        return len(set([_find(p, i) for i in range(len(M))]))