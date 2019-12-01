class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def dfs(row, cols, pie, na):
            if row == n:
                self.res += 1
                return

            bits = (~(cols | pie | na)) & ((1 << n)-1)
            while bits:
                p = bits & -bits
                bits = bits & (bits-1)
                dfs(row+1, cols | p, (pie | p) << 1, (na | p) >> 1)

        self.res = 0
        dfs(0, 0, 0, 0)
        return self.res