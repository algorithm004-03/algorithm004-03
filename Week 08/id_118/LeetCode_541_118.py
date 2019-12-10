# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 12/8/19

class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        if len(s) < (k): return s[::-1]
        if len(s) < (2 * k): return (s[:k][::-1] + s[k:])
        return s[:k][::-1] + s[k:2 * k] + self.reverseStr(s[2 * k:], k)
