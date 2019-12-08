class Solution(object):
    def permute(self, nums):
        """
        全排列：https://leetcode-cn.com/problems/permutations/
        
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #递归+回溯：
        #每次加入到结果集中，只要不是在结果集中出现的数字，都可以加入
        def bulid(l = []):
            if len(l) == size:
                self.result.append(l[:])
                return
            for num in nums:
                if not num in l:
                    l.append(num)
                    bulid(l)
                    l.pop()
            
        self.result = []
        size = len(nums)
        bulid()
        return self.result

        #写法2
        def dfs(l, val):
            l.append(val)
            if len(l) == len(nums):
                self.result.append(l)
                return 
            for num in nums:
                if num not in l:
                    dfs(l[:], num)
        self.result = []
        for num in nums:
            dfs([], num)
        return self.result