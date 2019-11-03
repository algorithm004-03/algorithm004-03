class Solution(object):
    def majorityElement(self, nums):
        """
        求众数：https://leetcode-cn.com/problems/majority-element/submissions/
        
        :type nums: List[int]
        :rtype: int
        """
        #hash表
        # m = collections.defaultdict(int)
        # for i in nums:
        #     m[i] += 1
        # n = len(nums) / 2
        # for key in m:
        #     if m[key] > n:
        #         return key
        
        #分治：
        #一个数组，均分为两半
        #1. 如果左边一半的众数 == 右边一半的众数，那么此数就是结果
        #2. 如果左边一半的众数 != 右边一半的众数，那么2个众数出现在数组里面的次数，次数较大值的那个为此数组的众数（因为涉及到回溯，所以这个说法成立，细想也是如此）
        #3. 如果数组元素只有一个，那么众数为此元素
        def majority(li, ri):
            if li == ri:
                return nums[li]
            m_i = (li + ri) / 2
            left = majority(li, m_i)
            right = majority(m_i + 1, ri)
            if left == right:
                return left
            left_count = sum(1 for i in range(li, ri + 1) if nums[i] == left)
            right_count = sum(1 for i in range(li, ri + 1) if nums[i] == right)
            return left if left_count > right_count else right
        
        return majority(0, len(nums) - 1)
        
        
        
    