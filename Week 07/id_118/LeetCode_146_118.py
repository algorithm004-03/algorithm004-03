# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/30/19
from collections import OrderedDict


class LRUCache:
    def __init__(self, capacity: int):
        self.dic = OrderedDict()
        self.remain = capacity

    def get(self, key):
        if key not in self.dic:
            return -1
        v = self.dic.pop(key)
        self.dic[key] = v
        return v

    def put(self, key, value):
        if key in self.dic:
            self.dic.pop(key)
        else:
            if self.remain > 0:
                self.remain -= 1
            else:
                self.dic.popitem(last=False)
        self.dic.update({key: value})
