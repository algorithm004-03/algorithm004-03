class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        #按字符串字母排序分组
        # result = []
        # d = collections.defaultdict(list)
        # for i in strs:
        #     d[tuple(sorted(i))].append(i)
        # for key,value in d.items():
        #     result.append(value)
        # return result
        
        #字符串每个字符为a-z26个字母
        #所以可以预设一个长为26的数组
        #每次字母出现在字符串s，就在数组的对应位置+1
        #得出的这个数组可以作为map的key，map的value为数组，且将s加入到数组
        result = []
        d = collections.defaultdict(list)
        for s in strs:
            r = [0] * 26
            for c in s:
                r[ord(c) - ord('a')] += 1
            d[tuple(r)].append(s)
        return d.values()
            
            
            
            
            
            
            
            
            
            
            
            