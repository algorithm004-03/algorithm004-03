# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/30/19

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and bin(n).count("1") == 1
