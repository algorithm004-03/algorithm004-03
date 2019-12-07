# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/30/19

class Solution:
    def slidingPuzzle(self, board):
        def swap(s, i, j):
            return (s[:i] + s[j] + s[i + 1:j] + s[i] + s[j + 1:]
                    if i < j else s[:j] + s[i] + s[j + 1:i] + s[j] + s[i + 1:])

        g = {0: {1, 3}, 1: {0, 2, 4}, 2: {1, 5}, 3: {0, 4}, 4: {1, 3, 5},
             5: {2, 4}}
        s, seen = "".join(map(str, sum(board, []))), set()
        q = [(s.index("0"), s, 0)]

        for i, s, k in q:
            if s == "123450":
                return k
            seen.add(s)
            q += [(j, ns, k + 1) for j in g[i] for ns in {swap(s, i, j)} if
                  ns not in seen]

        return -1
