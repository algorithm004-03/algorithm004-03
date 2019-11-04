//88. 合并有序数组

//解法1：arraycopy+sort		执行用时击败约71%
//时间复杂度O((n+m)*logN)
//空间复杂度O(1)
//总结：简单直观,效率一般
public void merge(int[] nums1, int m, int[] nums2, int n) {
	System.arraycopy(nums2, 0,nums1, m, n);
	Arrays.sort(nums1);
}

//解法2：双指针		执行用时击败约100%
//思路：双指针p1,p2分别指向两个数组的最后一个元素,设置p指针指向插入的位置,因为两个数组有序,p1和p2当前指向的都是数组中的最大元素,
//		比较大小,较大的放入p指针对应的位置即可
//		若p1指针先走完, p2指针还走完, 则p2指针剩下的部分一定是小于nums1的, 那么直接将该部分覆盖到nums1即可
//时间复杂度O(n+m)
//空间复杂度O(1)
public void merge(int[] nums1, int m, int[] nums2, int n) {
	int p1 = m - 1;
	int p2 = n - 1;
	int p = m + n - 1;
	while (p1 >= 0 && p2 >= 0) {
		nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
	}
	System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
}