# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/30/19
from typing import List


class Solution:
    def countBits(self, num:int) -> List[int]:
        initArr = [0]
        if num > 0:
            amountToAdd = 1
            while len(initArr) < num + 1:
                initArr.extend([x+1 for x in initArr])

        return initArr[0:num+1]