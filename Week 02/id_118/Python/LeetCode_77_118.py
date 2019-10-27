from typing import List


class Solution:
    """
    res is C(n,k)
    Follow strictly the generic recursion template
    """

    def __init__(self):
        self.res = []

    def _gen_comb(self, n, k, start, curr_c):
        # terminator
        if len(curr_c) == k:
            self.res.append(curr_c.copy())
            return
        # process the current level logic
        for i in range(start, n + 1):
            curr_c.append(i)
            # drill down
            self._gen_comb(n, k, i + 1, curr_c)

            # reverse to reset for the next recursion
            curr_c.pop()
        return

    def combine(self, n: int, k: int) -> List[List[int]]:
        # edge cases
        if n <= 0 or k <= 0 or k > n:
            return self.res
        curr_c = []
        self._gen_comb(n, k, 1, curr_c)
        return self.res


class Solution2:
    """
    A more optimized solution by removing unnecessary branches
    """

    def __init__(self):
        self.res = []

    def _gen_comb(self, n, k, start, curr_c):
        # terminator
        if len(curr_c) == k:
            self.res.append(curr_c.copy())
            return
        # process the current level logic
        # here no need to go to all the way to n (n+1 is not included in py)
        # for any given state, the available slots are k - len(curr_c)
        # so the stop point is n + 1 - (k - len(curr_c)) + 1
        for i in range(start, n - (k - len(curr_c)) + 2):
            curr_c.append(i)
            # drill down
            self._gen_comb(n, k, i + 1, curr_c)

            # reverse to reset for the next recursion
            curr_c.pop()
        return

    def combine(self, n: int, k: int) -> List[List[int]]:
        # edge cases
        if n <= 0 or k <= 0 or k > n:
            return self.res
        curr_c = []
        self._gen_comb(n, k, 1, curr_c)
        return self.res


if __name__ == '__main__':
    sol = Solution()
    res = sol.combine(7, 4)
    print(res)
    sol2 = Solution2()
    res2 = sol2.combine(7, 4)
    print(res2)
