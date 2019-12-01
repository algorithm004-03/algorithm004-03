//493. 翻转对

//解法1：暴力求解	执行超时
//思路：枚举所有i < j 的组合, 当nums[i]/2.0 > 2*nums[j]时, count++, 注意使用"/2.0"是为了在出现Integer.MAX_VALUE时避免越界
public int reversePairs(int[] nums) {
	int count = 0;
	for (int i = nums.length - 1; i >= 0; i--) {
		for (int j = 0; j < i; j++) {
			if (nums[j]/2.0 > nums[i]) count++;
		}
	}
	return count;
}

//解法2：归并排序	执行用时：59ms
//思路：基于归并排序的思路, 能够发现左半区域的index一定是小于右半区域的, 这样就可以满足翻转对的第一个条件i < j
//		接下来只需要观察左半区的元素中是否有大于右半区*2的元素, 找到了count++即可
//		因为归并排序的特性, 检索过的区间都被置为有序, 也就意味着不会出现重复判断的情况
//时间复杂度：O(log2N)
//空间复杂度：O(n)
public int reversePairs(int[] nums) {
	if (nums.length == 0 || nums == null) return 0;
	return mergeSort(nums, 0, nums.length - 1);
}

private int mergeSort(int[] nums, int left, int right) {
	if (left >= right) return 0;
	int[] temp = new int[right - left + 1];
	int mid = left + ((right - left) >> 1);
	int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
	int reverseIdx = left, i = left, k = 0;
	for (int j = mid + 1; j <= right; j++) {
		while (reverseIdx <= mid && nums[reverseIdx]/2.0 <= nums[j]) {
			reverseIdx++;
		}
		while (i <= mid && nums[i] <= nums[j] ) {
			temp[k++] = nums[i++];
		}
		count += mid + 1 - reverseIdx;
		temp[k++] = nums[j];
	}
	while (i <= mid) {
		temp[k++] = nums[i++];
	}
	System.arraycopy(temp, 0, nums, left, temp.length);
	return count;
}