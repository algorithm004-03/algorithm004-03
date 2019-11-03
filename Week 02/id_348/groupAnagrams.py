class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        tmp_strs = {}
        for s in strs:
            tmp_s = "".join(sorted(s))
            if tmp_s not in tmp_strs.keys():
                tmp_strs[tmp_s] = [s]                
            else:
                tmp_strs[tmp_s].append(s)
        return tmp_strs.values()