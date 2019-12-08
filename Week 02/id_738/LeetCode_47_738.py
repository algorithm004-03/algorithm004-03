class Solution(object):
    def permuteUnique(self, nums):
        """
        全排列2：https://leetcode-cn.com/problems/permutations-ii/
        
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #递归+回溯：
        #每次加入到结果集中，只要不是在结果集中出现的数字，都可以加入
        #过程涉及到nums的切片操作，最后设计到判断去重，感觉效率很低：执行时间1000+Ms,被 80%同行打败。。。
        #优化：剪枝，如果本层再次出现以及处理过的数字，那么不用重复执行：执行时间48Ms,打败了80+%同行。。。
        #剪枝后留下的问题：
        # 1. 数组的切片操作，要多复制一份数据到空间，对时间复杂度也有影响
        # 2. 递归剪枝中里面每次都要判断当前处理的数字是否在Nums之前处理过的数字中，感觉很浪费时间
        
#         def bulid(nums = nums, l = []):
#             if len(l) == size:
#                 self.result.append(l[:])
#                 return
#             for i in range(len(nums)):
#                 #剪枝，如果nums[i]没有出现过
#                 if nums[i] not in nums[:i]:
#                     l.append(nums[i])
#                     bulid(nums[0:i] + nums[i+1:], l)
#                     l.pop()
            
#         self.result = []
#         size = len(nums)
#         bulid()
#         return self.result
    
        #针对上面“剪枝后留下的问题”，
        # 1.设法不要将数组进行切片操作，
        # 2.设法在递归过程中判断去重，但是不需要重复扫描之前处理过的数组
        # 优化后的解法如下：
        # 结果：执行时间提高到40-44ms，打败了 90+%的同行。。。
        
        def bulid(nums = nums, l = []):
            if len(l) == size:
                self.result.append(l[:])
                return
            for i in range(len(nums)):
                #剪枝，如果nums[i]没有出现过
                #这里Nums是排序过的，解决在递归过程中判断去重，需要重复扫描之前处理过的数组的问题
                if i == 0 or nums[i] != nums[i - 1]:
                    #通过对nums的pop和insert操作，去除已经处理过的数字，还原现场
                    tmp = nums.pop(i)
                    l.append(tmp)
                    bulid(nums, l)
                    nums.insert(i, tmp)
                    l.pop()
            
        self.result = []
        size = len(nums)
        #排序，解决在递归过程中判断去重，需要重复扫描之前处理过的数组的问题
        nums.sort()
        bulid()
        return self.result