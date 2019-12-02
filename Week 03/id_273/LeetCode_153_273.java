//153. 寻找旋转排序数组中的最小值

//解法1：二分查找		执行用时击败100%
//思路：根据二分查找的有序性, 寻找数组中的偏移点
//		如果当前mid > nums[right], 说明偏移点存在于[mid + 1, right]
//		else 如果当前mid <= nums[right], 说明(mid, right]这部分是有序的, 偏移点存在于[left, mid]
//时间复杂度：O(logN)
//空间复杂度：O(1)
public int findMin(int[] nums) {
	int left = 0; 
	int right = nums.length - 1;
	while (left < right) {
		int mid = (left + right) >> 1;
		if (nums[mid] > nums[right]) {
			left = mid + 1;
		} else {
			right = mid;
		}
	}
	return nums[left];
}

//解法2：作弊		执行用时击败100%
//思路：因为是有序数组旋转, 直接寻找数组中最小的元素, 它就是偏移点
//时间复杂度：O(n)
//空间复杂度：O(1)
public int findMin(int[] nums) {
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < nums.length; i++) {
		if (min > nums[i]) min = nums[i];
	}
	return min;
}