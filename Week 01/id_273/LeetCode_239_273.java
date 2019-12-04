//239 滑动窗口最大值

//解法1：暴力求解，看到这个题目一开始想到的解法就是用数组辅助存储了
//temp2[]存储每次滑动窗口中的k个元素
//temp1[]每次筛选出temp2中的最大值进行存储
//时间复杂度O(n^2)
//空间复杂度O(n)
public int[] maxSlidingWindow(int[] nums, int k) {
	if (k == 0) return new int[0];
	int temp1[] = new int[nums.length-k+1];//用于存放temp2中的最大值
	int count = 0;
	for (int i = 0;i<nums.length-k+1;i++) {
		int temp2[] = new int[k];//用于存放每次滑动窗口中的元素
		int m = 0;
		for (int j = i;j<i+k;j++) {//
			temp2[m++] = nums[j];
		}
		temp1[count++] = getMax(temp2);
	}
	return temp1;
}

private int getMax(int[] arr) {
	int max = -999999999;
	for (int i = 0;i<arr.length;i++) {
		if (arr[i]>max) {
			max = arr[i];
		}
	}
	return max;
}