class Solution:
    def groupAnagrams(self, strs):
        # 创建一個类似 map 的 dict
        dict = {}
        for i in range(len(strs)):
            if dict.get(tuple(sorted(strs[i]))):
                dict[tuple(sorted(strs[i]))] += [strs[i]]
            else:
                dict.setdefault(tuple(sorted(strs[i])), [strs[i]])
        return list(dict.values())


s = Solution()
print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
