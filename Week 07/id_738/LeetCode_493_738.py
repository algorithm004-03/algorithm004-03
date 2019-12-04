class Solution(object):
    # 解法1
    def reversePairs(self, nums):
        """
        翻转对：https://leetcode-cn.com/problems/reverse-pairs/
        逆序对：对于(i, j), i < j 并且 nums[i] > nums[j]的对，称为逆序对
        对逆序对求解出所需要的东西，是在算法中非常经典的问题，需要重视

        :type nums: List[int]
        :rtype: int
        """
        # 对于逆序对的问题，我们使用归并排序进行解决，时间复杂度O(nlogn)
        # 归并排序是解决逆序对的最高效手段
        self.result = 0
        self.mergeSort(nums, 0, len(nums) - 1)
        return self.result
    
    def mergeSort(self, nums, start, end):
        if start >= end:
            return
        mid = (start + end) >> 1
        self.mergeSort(nums, start, mid)
        self.mergeSort(nums, mid + 1, end)
        # 由于左右都有序了，这里就可以利用这个特点来统计逆序对
        j = mid + 1
        for i in range(start, mid + 1):
            while j <= end and nums[i] > nums[j] * 2:
                j += 1
            self.result += (j - (mid + 1))
        self.merge(nums, start, mid, end)

    def merge(self, nums, start, mid, end):
        tmp = [0 for _ in range(end - start + 1)]
        k, i, j = 0, start, mid + 1
        while i <= mid and j <= end:
            if nums[i] <= nums[j]:
                tmp[k] = nums[i]
                i += 1
            else:
                tmp[k] = nums[j]
                j += 1
            k += 1
        if i <= mid:
            tmp[k:] = nums[i: mid + 1]
        if j <= end:
            tmp[k:] = nums[j: end + 1]
        nums[start: end + 1] = tmp


###################################################
    #解法2
    def reversePairs(self, nums):
        self.count = 0
        self.MergeSort(nums, 0, len(nums)-1)
        return self.count

    def MergeSort(self, array, first, last):
        cnt = []
        if first >= last:
            return
        mid = first + int((last - first)/2)
        self.MergeSort(array, first, mid)
        self.MergeSort(array, mid+1, last)
        self.Merge(array, first, mid, last)
    
    def Merge(self, array, first, mid, last):
        i = first
        j = mid + 1
        while (i<=mid and j<=last):
            if (array[i] <= 2*array[j]):
                i += 1
            else:
                j += 1
                self.count += mid-i+1
        array[first:last+1] = sorted(array[first:last+1])

####################################################

    #解法3
    def reversePairs(self, nums):
        self.result = 0
        self.mergeSort(nums, 0, len(nums) - 1)
        return self.result
    
    def mergeSort(self, nums, start, end):
        if start >= end:
            return
        mid = (start + end) >> 1
        self.mergeSort(nums, start, mid)
        self.mergeSort(nums, mid + 1, end)
        self.merge(nums, start, mid, end)

    def merge(self, nums, start, mid, end):
        cache = [0 for _ in range(end - start + 1)]
        c = 0
        j = mid + 1
        t = mid + 1
        for i in range(start, mid + 1):
            # 统计逆序对
            while t <= end and nums[i] > nums[t] * 2:
                t += 1
            self.result += (t - (mid + 1))
            # 归并排序部分
            while j <= end and nums[j] < nums[i]:
                cache[c] = nums[j]
                c += 1
                j += 1
            cache[c] = nums[i]
            c += 1
            
        # 对剩下的j进行加入到cache中
        # if j <= end:
        #     cache[c:] = nums[j: end + 1]
        while j <= end:
            cache[c] = nums[j]
            c += 1
            j += 1
        # 写回主数组nums
        # nums[start: end + 1] = cache
        for i in range(len(cache)):
            nums[start + i] = cache[i]




















        



