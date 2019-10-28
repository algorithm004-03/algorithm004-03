class Solution(object):
    
    def __init__(self):
        self.result = []
    
    def generateParenthesis(self, n):
        """
        括号生成:https://leetcode-cn.com/problems/generate-parentheses/submissions/

        :type n: int
        :rtype: List[str]
        """
        self.generate(0, 0, "", n)
        return self.result
        
    def generate(self, left, right, s, n):
        if left == n and right == n:
            self.result.append(s)
        if left < n:
            self.generate(left + 1, right, s + '(', n)
        if right < n and left > right:
            self.generate(left, right + 1, s + ')', n)