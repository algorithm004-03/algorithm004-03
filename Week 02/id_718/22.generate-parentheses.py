#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ret = []
        self._gen(n, ret, "", 0, 0)
        return ret
    
    def _gen(self, n, ret, result, left, right):
        if left == n and right == n:
            ret.append(result[:])
            return
        if left < n:
            self._gen(n, ret, result + "(", left + 1, right)
        if right < left:
            self._gen(n, ret, result + ")", left, right + 1)

'''
 class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def _gen(n, out, ret, left, right):
            if left == n and right == n:
                ret.append(out[:])
                return
            if left < n:
                _gen(n, out + "(", ret, left + 1, right)
            if right < left:
                _gen(n, out + ")", ret, left, right + 1)
        ret = []
        _gen(n, "", ret, 0, 0)
        return ret
'''
# @lc code=end

