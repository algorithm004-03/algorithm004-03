class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        #判断t和t中的单词分类及其数量是否相等
        dict_d = {}
        for i in s:
            dict_d[i] = dict_d.get(i, 0) + 1
        dict_t = {}
        for i in t:
            dict_t[i] = dict_t.get(i, 0) + 1
        return dict_d == dict_t
        
        #利用python api：
        #先去重，再比较各个字母在s和t中的数量
        # if len(s) != len(t):
        #     return False
        # s_single = set(s)
        # for i in s_single:
        #     if s.count(i) != t.count(i):
        #         return False
        # return True
        
        
        
        
        