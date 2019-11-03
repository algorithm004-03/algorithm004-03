class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        temp_m = m
        temp_n = n
        if m == 0 and n == 1:
            nums1[-1] = nums2[-1]
        elif m == 1 and n == 1:
            if nums1[m - 1] > nums2[n - 1]:
                nums1[-1] = nums1[0]
                nums1[0] = nums2[0]
            else:
                nums1[-1] = nums2[0]
        else:
            for idx in range(len(nums1)): 
                if n != 0 and m == 0:
                    for i_n in range(n):
                        if n == temp_n:
                            nums1[len(nums1) - 1 - temp_m - i_n] = nums2[n - 1 - i_n]
                        else:
                            nums1[(len(nums1) - 1) - temp_m - (len(nums2) - n) - i_n] = nums2[n - 1 - i_n]
                elif n != 0 and m != 0:
                    if nums1[m - 1] >= nums2[n - 1]:
                        nums1[len(nums1) - 1 - idx] = nums1[m - 1]
                        m = m - 1
                    elif nums1[m - 1] < nums2[n - 1]:
                        nums1[len(nums1) - 1 - idx] = nums2[n - 1]
                        n = n - 1
                else:
                    return
