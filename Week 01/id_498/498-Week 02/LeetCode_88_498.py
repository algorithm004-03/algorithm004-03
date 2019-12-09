class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums1[:] = sorted(nums1[:m] + nums2)
        return nums1


s = Solution()
print(s.merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6],3))

