# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/30/19

class Solution:
    def reverseBits(self, n: int) -> int:
        return int('{0:032b}'.format(n)[::-1], 2)
