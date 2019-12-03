# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/30/19
class Solution:
    def hammingWeight(self, n:int) -> int:
        return str(bin(n)).count("1")