class Solution_1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)-1):
            for r in range(i+1,len(nums)):
                if nums[i] + nums[r] == target: #注意这里的相等是==号
                    return [i,r]  #返回一个列表

class Solution_2:
    # 可用一遍遍历，即根据当前遍历得到的元素index，
    # 查找target-index是否在剩余数组里出现
    # 如果找得到，则返回其下标值；反之则说明没有该答案
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        answer = []
        for left_index in range(len(nums)):
            right = target - nums[left_index]
            if right in nums[left_index+1:]:
                nums_right = nums[left_index+1:] #往右截断，构建一个新的数组
                right_index = nums_right.index(right)+left_index+1 #注意这个+1
                answer.extend([left_index, right_index])
                break
        return answer