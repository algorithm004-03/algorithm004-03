class Solution(object):
    def canJump(self, nums):
        """
        跳跃游戏：https://leetcode-cn.com/problems/jump-game/
        
        :type nums: List[int]
        :rtype: bool
        """
        #动态规划 - （最后一个超大数组的测试用例）超出内存限制
        # def canJumpFromPosition(position, nums):
        #     if memo[position] != -1:
        #         return True if memo[position] == 1 else False
        #     furthestJump = min(position + nums[position], len(nums) - 1)
        #     for nextPosition in range(position + 1, furthestJump + 1):
        #         if canJumpFromPosition(nextPosition, nums):
        #             memo[position] = 1
        #             return True
        #     memo[position] = 0;
        #     return False;
            
        
        # memo = []
        # for i in range(len(nums)):
        #     memo.append(-1)
        # memo[-1] = 1;
        # return canJumpFromPosition(0, nums);
        
##################################################################################

        # （最后一个超大数组的测试用例）超出时间限制
        # queue = [0]
        # end = len(nums) - 1
        # while queue:
        #     cur = queue.pop(0)
        #     if cur + nums[cur] >= end:
        #         return True
        #     for i in range(1, nums[cur] + 1):
        #         n = cur + i
        #         if n <= end and n not in queue:
        #             queue.append(n)
        # return False

##################################################################################        

        # 贪心法
        cur = len(nums) - 1
        for i in range(len(nums) - 1)[::-1]:
            if cur - i <= nums[i]:
                cur = i
        if cur == 0:
            return True
        return False