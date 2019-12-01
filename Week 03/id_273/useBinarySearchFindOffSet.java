// 使用二分查找寻找半有序数组的偏移量

//思路：left = 0 , right = length - 1, mid = (left + right)/2, 观察arr[mid]是否大于arr[right]
//		若大于说明序列在mid之后的位置进行了旋转, mid+1位置可能是偏移点, 也可能是mid+i
//			此时left = mid + 1, 折半继续查找
//		若小于等于说明mid之后都为有序序列, 偏移点位于mid之前
//			此时right = mid, 折半继续查找
//		到最后, left所指向的index则是整个数组中最小的位置, 也就是偏移点

public void findOffSet(int nums []) {
	int left = 0;
	int right = nums.length - 1;
	while (left < right) {
		int mid = (left + right) >> 1;
		if (nums[mid] > nums[right]) left = mid + 1;
		else right = mid;
	}
	return left;
}