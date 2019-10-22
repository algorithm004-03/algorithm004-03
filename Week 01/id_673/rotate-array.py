 class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        for i in range(k):
            tmp = nums[-1]
            for j in range(len(nums)-1, 0, -1):
                nums[j] = nums[j-1]
            nums[0] = tmp
