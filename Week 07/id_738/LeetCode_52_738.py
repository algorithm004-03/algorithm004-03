class Solution(object):
    def totalNQueens(self, n):
        """
        N皇后二：https://leetcode-cn.com/problems/n-queens-ii/submissions/

        :type n: int
        :rtype: int
        """
        self.res = 0
        self.dfs(n, 0, 0, 0, 0)
        return self.res
        
    def dfs(self, n, row , col, pie, na):
        if n == row:
            self.res += 1
            return
        # 二进制位，为1的位置表示可以放置皇后
        # 这里设为1的位置表示可以放置皇后是因为方便后的while判断是否还有空位(只需判断bits是否为0就可以了，为0表示没空位)
        # (如果设为0的位置可以放置皇后，那么只有当bits为11111才表示没有空位，那么wihle循环难以判断bits是否全为1)
        # 下面操作计算出一个二进制，为1的位置表示可以放皇后，为0表示不能放皇后
        bits = (~(col | pie | na)) & ((1 << n) - 1)
        # 如果bits中还有1，表示还有空位可以放置皇后，循环所有可能
        while bits:
            # 从最低位1的位置开始放置皇后
            # 将最低位的1取出来，比如1010取出来就是0010
            # bits & -bits效果就是取出最低位的1
            p = bits & -bits
            # 先将最低位1置为1表示放置了皇后，以便下次while判断
            bits = bits & (bits - 1)
            # 下探下一行，继续放皇后
            # 在p的二进制位放置皇后，那么下一层：
            # 不能在当前col为1的位置和col的p位置放置皇后，所以col | p
            # 不能在当前pie为1的位置和pie的p位置的左移一位放置皇后，所以(pie | p) << 1
            # 不能在当前na为1的位置和na的p位置的右移一位放置皇后，所以(na | p) >> 1 )
            self.dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1 )



