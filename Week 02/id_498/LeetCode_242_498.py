class Solution:
    def isAnagram(self, s, t):
        # 先判断两个字符串是否等长
        if len(s) != len(t):
            return False
        # 创建计数器，26
        counter = [0 for az in range(26)]
        # 把字符串的每个字母都使用 ASCII hash 一下
        for i in range(len(s)):
            # 放到计数器里，对应的下标，值加1
            counter[ord(s[i]) - 97] += 1
            # 如果找到相应的ASCII 值就减 1
            counter[ord(t[i]) - 97] -= 1
        # 如果计数器所有值都是0，证明一样
        for ii in counter:
            if ii != 0:
                return False
        return True


s = Solution()
print(s.isAnagram("anagram", "nagaram"))
