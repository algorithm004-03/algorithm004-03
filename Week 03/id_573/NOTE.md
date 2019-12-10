# NOTE 

#### 寻找旋转排序数组中的最小值 

#### 思路：
    
    旋转排序数组 numsnums 可以被拆分为 2 个排序数组 nums1nums1 , nums2nums2 ，并且 nums1任一元素 >= nums2任一元素；因此，考虑二分法寻找此两数组的分界点 nums[i]nums[i] (即第 2 个数组的首个元素)。
    设置 leftleft, rightright 指针在 numsnums 数组两端，midmid 为每次二分的中点：
    当 nums[mid] > nums[right]时，midmid 一定在第 1 个排序数组中，ii 一定满足 mid < i <= right，因此执行 left = mid + 1；
    当 nums[mid] < nums[right] 时，midmid 一定在第 2 个排序数组中，ii 一定满足 left < i <= mid，因此执行 right = mid；
    当 nums[mid] == nums[right] 时，是此题对比 153题 的难点（原因是此题中数组的元素可重复，难以判断分界点 ii 指针区间）；
    例如 [1, 0, 1, 1, 1][1,0,1,1,1] 和 [1, 1, 1, 0, 1][1,1,1,0,1] ，在 left = 0, right = 4, mid = 2 时，无法判断 midmid 在哪个排序数组中。
    我们采用 right = right - 1 解决此问题，证明：
    此操作不会使数组越界：因为迭代条件保证了 right > left >= 0；
    此操作不会使最小值丢失：假设 nums[right]nums[right] 是最小值，有两种情况：
    若 nums[right]nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
    若 nums[right]nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，即还有最小值存在于 [left, right - 1][left,right−1] 区间，因此不会丢失最小值。
    
    以上是理论分析，可以代入以下数组辅助思考：
        [1, 2, 3][1,2,3]
        [1, 1, 0, 1][1,1,0,1]
        [1, 0, 1, 1, 1][1,0,1,1,1]
        [1, 1, 1, 1][1,1,1,1]
    时间复杂度 O(logN)O(logN)，在特例情况下会退化到 O(N)O(N)（例如 [1, 1, 1, 1][1,1,1,1]）。

  
    旋转排序数组nums可以被拆分为2个排序数组nums1, nums2，并且nums1中所有元素比nums2大（因为nums中没有重复值）；
    因此，考虑二分法寻找值nums[i]，满足nums[i] < nums[i-1] and nums[i] < nums[i+1]
    设置left, right指针在nums数组两端，mid为中点：
        当nums[mid] > nums[right]时，一定满足mid < i <= right，因此left = mid + 1；
        当nums[mid] < nums[right]时，一定满足left< i <= mid，因此right = mid；
        当nums[mid] == nums[right]时，说明数组长度len(num) == 1（因为计算mid向下取整）；当left = right也满足，但本题left == right时跳出循环。

