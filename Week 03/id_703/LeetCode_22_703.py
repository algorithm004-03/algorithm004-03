#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#

# @lc code=start
from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        total_l = []
        total_l.append([None])  
        total_l.append(["()"])   
        for i in range(2,n+1):    
            l = []        
            for j in range(i):   
                now_list1 = total_l[j]    
                now_list2 = total_l[i-1-j]    
                for k1 in now_list1:  
                    for k2 in now_list2:
                        if k1 == None:
                            k1 = ""
                        if k2 == None:
                            k2 = ""
                        el = "(" + k1 + ")" + k2
                        l.append(el)    
            total_l.append(l)    
        return total_l[n]

# @lc code=end

