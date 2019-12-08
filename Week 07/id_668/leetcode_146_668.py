#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: 146_lru_cache.py
    @time: 2019/12/1 12:41
"""
import collections


class LRUCache(object):
    """
        运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

        获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
        写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，
        从而为新的数据值留出空间。

        进阶:
        你是否可以在 O(1) 时间复杂度内完成这两种操作？

        示例:
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    """

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.dict = collections.OrderedDict()
        self.remain = capacity  # remain表示可装入的缓存元素数量，当值为0时，表示已满；此时若加入新的缓存元素，则需要删除老的缓存元素

    def get(self, key):
        """
        :type key: int
        :rtype: int

        策略：获取缓存元素，如果不存在则返回-1，若存在，则需要将其从原有位置移动到最新的位置，因为这个缓存元素是最新被访问过
        """
        if key not in self.dict:
            return -1

        v = self.dict.pop(key)
        self.dict[key] = v

        return v

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None

        添加缓存元素：如果已在缓存池中，则将其从原有位置移动到最新位置，这里的做法是将原有位置的缓存元素pop，然后在最新位置加入
        如果不存在，这个时候需要判断缓存池是否已满，若没满，则直接添加同时缓存剩余量-1；若已满，则需要将老的缓存元素pop出一个，
        然后加入新的元素
        """
        if key in self.dict:
            self.dict.pop(key)
        else:
            if self.remain > 0:
                self.remain -= 1
            else:
                # 参数last=False以FIFO order pop element
                self.dict.popitem(last=False)  # 缓存池已满，需要将最先进来且没被使用的缓存元素给清理掉

        self.dict[key] = value

