from typing import List


class Solution:
    """
    This method strictly follow the generic backtracking template
    """

    def __init__(self):
        self.res = []
        # conflict check lists
        self.col, self.dia1, self.dia2 = [], [], []

    def solveNQueens(self, n: int) -> List[List[str]]:
        # Edge case
        if n == 1:
            return [["Q"]]
        if n < 4 and n != 1:
            return self.res
        row = []
        self.col = [False] * n
        self.dia1 = [False] * (2 * n - 1)
        self.dia2 = [False] * (2 * n - 1)
        self._gen_queen(0, n, row)
        return self.res

    def _gen_queen(self, curr_level, n, row):
        # Step 1: Terminator
        if curr_level == n:
            self.res.append(self._gen_board(n, row))
            return

        # Step 2: Process the current level logic
        for i in range(n):
            if (not self.col[i]) and (not self.dia1[curr_level + i]) and (
                    not self.dia2[curr_level - i]):
                row.append(i)
                self.col[i] = True
                self.dia1[curr_level + i] = True
                self.dia2[curr_level - i] = True

                # Step 3: drill down
                self._gen_queen(curr_level + 1, n, row)

                # Step 4: Reverse
                row.pop()
                self.col[i] = False
                self.dia1[curr_level + i] = False
                self.dia2[curr_level - i] = False
        return

    def _gen_board(self, n, row):
        return ["." * i + "Q" + "." * (n - i - 1) for i in row]


if __name__ == '__main__':
    sol = Solution()
    res = sol.solveNQueens(4)
    print(res)
