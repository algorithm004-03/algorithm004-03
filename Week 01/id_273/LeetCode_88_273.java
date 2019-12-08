//88. 合并有序数组

//解法1：arraycopy+sort		执行用时击败约71%
//时间复杂度O((n+m)*logN)
//空间复杂度O(1)
//总结：简单直观,效率一般
public void merge(int[] nums1, int m, int[] nums2, int n) {
	System.arraycopy(nums2, 0,nums1, m, n);
	Arrays.sort(nums1);
}

//解法2：双指针		执行用时：0ms
//思路：可以参考归并排序的merge操作, 
//		优化代码：在第一次nums1赋值结束后, 若i指针先指向0, 那么j指针剩下的部分可以直接覆盖掉nums1
//								 		   若j指针先指向0, 那么i指针剩下的部分就是原本nums1的部分, 不用再操作
//时间复杂度O(n+m)
//空间复杂度O(1)
public void merge(int[] nums1, int m, int[] nums2, int n) {
	int i = m - 1; int j = n - 1; int k = nums1.length - 1;
	while (i >= 0 && j >= 0) {
		nums1[k--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
	}
	// while (i >= 0) nums1[k--] = nums1[i--];
	// while (j >= 0) nums1[k--] = nums2[j--];
	System.arraycopy(nums2, 0, nums1, 0, j + 1);
}