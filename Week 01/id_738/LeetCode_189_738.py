class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        #方法1：暴力法，一步一步移动，时间复杂度O(k * n)
        #提交的时候会超时..
        # if len(nums) <= 1:
        #     return
        # for i in range(k):
        #     next_val = nums[0]
        #     for cur_index in range(len(nums)):
        #         next_index = (cur_index + 1) % len(nums)
        #         nums[next_index], next_val = next_val, nums[next_index]
        
        # 方法2：
        # 数组长度为n，要移动n次是肯定的
        # 考虑能否一次到位，直接将i移动到i+k位置
        # n % k == 0 和 != 0的情况不同
        # l = len(nums)
        # k = k % l
        # count = 0
        # start = 0
        # while count < l:
        #     tmp = nums[start]
        #     cur_index = start
        #     while True:
        #         next_index = (cur_index + k) % l
        #         nums[next_index], tmp = tmp, nums[next_index]
        #         cur_index = next_index
        #         count += 1
        #         if start == cur_index:
        #             break
        #     start += 1

        #下面是方法2的另一种写法
        count = LEN = len(nums)
        k = k % LEN
        CUR = START = 0
        CUR_TMP = nums[0]
        while True:
            NEXT = (CUR + k) % LEN
            NEXT_TMP = nums[NEXT]
            nums[NEXT] = CUR_TMP
            CUR_TMP = NEXT_TMP
            CUR = NEXT
            count -= 1
            if count == 0:
                break
            if START == CUR:
                START += 1
                CUR += 1
                CUR_TMP = nums[CUR]
