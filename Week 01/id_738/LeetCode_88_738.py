class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        #双指针从前往后，遍历两个数组 m + n，但是插入的时候还需要logn
        #所以时间复杂度为 O((m+n)log(n+m))
        # cur_1, cur_2 = 0, 0
        # while cur_1 < m and cur_2 < n:
        #     while cur_1 < m and nums1[cur_1] < nums2[cur_2]:
        #         cur_1 += 1
        #     nums1.insert(cur_1, nums2[cur_2])
        #     nums1.pop()
        #     cur_1 += 1
        #     cur_2 += 1
        #     m += 1
        # if cur_1 >= m:
        #     while cur_2 < n:
        #         nums1[cur_1] = nums2[cur_2]
        #         cur_2 += 1
        #         cur_1 += 1
        
        # 由于nums1后面为留空位置，如果从后面插入，那么不需要移动元素
        cur_1, cur_2, p = m - 1, n - 1, len(nums1) - 1
        while cur_1 >=0 and cur_2 >= 0:
            if nums1[cur_1] > nums2[cur_2]:
                nums1[p] = nums1[cur_1]
                cur_1 -= 1
            else:
                nums1[p] = nums2[cur_2]
                cur_2 -= 1
            p -= 1
        if cur_2 >= 0:
            nums1[:cur_2 + 1] = nums2[:cur_2 + 1]
        
        
        
        
        
        