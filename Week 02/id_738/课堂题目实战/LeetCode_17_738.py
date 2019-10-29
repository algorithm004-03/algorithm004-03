class Solution(object):
    
    def letterCombinations(self, digits):
        """
        电话号码的字母组合：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
        
        :type digits: str
        :rtype: List[str]
        """
        self.phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}
        
        def combinations(digits_i, s):
            if len(s) == len(digits_l):
                self.result.append(s)
                return
            
            letters = self.phone[digits_l[digits_i]]
            for letter in letters:
                combinations(digits_i + 1, s + letter)
        
        if digits == "":
            return []
        self.result = []
        digits_l = list(digits)      
        combinations(0, '')
        return self.result
            
            
            
            
            
            
            
            
    
    