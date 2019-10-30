from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        """

        """
        res = []
        s = "." * n

        def backtrack(i, tmp, col, z_diagonal, f_diagonal):
            if i == n:
                res.append(tmp)
                return
            for j in range(n):
                #  纵坐标没在列集合、横纵坐标之和没在横纵主斜线集合、横纵坐标之差没在副斜线集合
                if j not in col and i + j not in z_diagonal and i - j not in f_diagonal:
                    #         下一行  . 就替换成 Q                     并集        并集
                    # 不用担心主副对角线
                    backtrack(i + 1, tmp + [s[:j] + "Q" + s[j + 1:]], col | {j}, z_diagonal | {i + j},
                              f_diagonal | {i - j})

        backtrack(0, [], set(), set(), set())
        return res


s = Solution()
print(s.solveNQueens(4))
