使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。
总体思路：
1.找出最小值，目的是找出数组的旋转点，为了后面直接寻找做准备。
2. 二分查找方法的存在的前提的单调递增。
3. 根据最小值和目标target值进行判断，找出左右边界，然后用二分查找方法进行查找。
代码参考LeetCode_33_048.

二分查找代码模板：
left, right = 0, len(array) - 1
while left <= right:
	  mid = (left + right) / 2
	  if array[mid] == target:
		    # find the target!!
		    break or return result
	  elif array[mid] < target:
		    left = mid + 1
	  else:
		    right = mid - 1


