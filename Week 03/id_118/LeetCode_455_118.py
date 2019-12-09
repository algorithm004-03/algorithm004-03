# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 10/31/2019
from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g, s = sorted(g, reverse=True), sorted(s, reverse=True)

        res, g_i, s_i = 0, 0, 0

        while g_i < len(g) and s_i < len(s):
            if g[g_i] <= s[s_i]:
                res += 1
                g_i += 1
                s_i += 1
            else:
                g_i += 1
                
        return res
