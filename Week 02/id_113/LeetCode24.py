class Solution:
# 排序暴力法
    def isAnagram(self, s: str, t: str) -> bool:
        s_array = list(s)
        t_array = list(t)

        if sorted(s_array) == sorted(t_array):
            return True
        else:
            return False

#   字典计数法
    def isAnagram(self, s: str, t: str) -> bool:
        s_dict = {}
        t_dict = {}
        for i in s:
            if s_dict.get(i,0) == 0:
                s_dict[i] = 1
            else:
                s_dict[i] += 1
#
        for j in t:
            if t_dict.get(j,0) == 0:
                t_dict[j] = 1
            else:
                t_dict[j] += 1

        if s_dict == t_dict:
            return True
        else:
            return False
