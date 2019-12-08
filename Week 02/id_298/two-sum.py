class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
       
      results = {}
      for idx, num in enumerate(nums):
        if target - num in results:
          return [results[target - num], idx]
        results[num] = idx
      
      # target - num 查以前的数， num是当前的数，如果当前数对应的key不在，则添加索引
      # 如果 data = target - num 就是要找的数字 如果 num
      # num * 2 == target的单个num
      # 还有 num1 = num2 and target = num1 + num2class Solution:
