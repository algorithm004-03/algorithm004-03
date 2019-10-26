class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # j 是稳步增加
        j = 0
        for i in range(len(nums)):
            # 找非0项
            if nums[i] != 0:
                # i 不能和 j 相同否则就为0了
                if i != j:
                    nums[j] = nums[i]
                    nums[i] = 0
                    # 只有找到非0项才往后移
                j += 1
        return nums
