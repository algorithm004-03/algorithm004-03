# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/17/2019

class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        cache = [[False for _ in range(len(s))] for _ in range(len(s))]

        for i in range(len(s)):
            for j in range(i):
                if i - j <= 2:
                    cache[j][i] = (s[j] == s[i])

                else:
                    cache[j][i] = (s[j] == s[i] and cache[j + 1][i - 1])

                if cache[j][i]:
                    count += 1
            cache[i][i] = True
            count += 1

        return count
